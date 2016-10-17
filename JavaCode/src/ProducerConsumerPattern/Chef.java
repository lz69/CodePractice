package ProducerConsumerPattern;
import java.util.concurrent.TimeUnit;

public class Chef implements Runnable{

	private Restaurant restaurant;
	
	private int count = 0;
	
	public Chef(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized (this) {
					while(restaurant.meal != null)
						wait();
				}
				if(++count == 10) {
					System.out.println("Out of food. closing");
					restaurant.exec.shutdownNow();
					return;
				}
				System.out.println("Order up!");
				synchronized (restaurant.waitPerson) {
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch(InterruptedException e) {
			System.out.println("Chef interrupted");
		}
	}

}
