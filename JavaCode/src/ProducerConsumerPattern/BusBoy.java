package ProducerConsumerPattern;

public class BusBoy implements Runnable{

	private Restaurant restaurant;
	
	public BusBoy(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized (this) {
					while(restaurant.meal == null)
						wait();
				}
				System.out.println("BusBoy clean " + restaurant.meal);
				synchronized (restaurant.waitPerson) {
					restaurant.meal = null;
					restaurant.waitPerson.notifyAll();
				}
				
			}
		} catch (InterruptedException e) {
			System.out.println("BusBoy interrupted");
		}
	}

}
