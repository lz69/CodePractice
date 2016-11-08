class Student(object):
    def __init__(self, name, score):
        self.name = name
        self.score = score
    def print_score(self):
        print('%s, %s'% (self.name,self.score))

bart = Student('Bart Simpson', 59)
lisa = Student('Lisa Simpson', 89)
bart.print_score();
lisa.print_score();

class Animal(object):
    def run(self):
        print('Animal is running...')
a = Animal()
a.run()

class Dog(Animal):
    pass
d = Dog()
d.run()

class Cat(Animal):
    def run(self):
        print('Cat is running...')
c = Cat()
c.run()

def run(animal):
    animal.run()
run(Dog())
