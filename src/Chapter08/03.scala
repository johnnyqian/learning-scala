package chapter08 {
  abstract class Animal {
    def makeSound
  }

  class Cat extends Animal {
    def makeSound {
      println("I'm a cat, Miao!")
    }
  }

  class Dog extends Animal {
    def makeSound {
      println("I'm a dog, Wang!")
    }
  }

  object Test03 extends App {
    val cat = new Cat
    cat.makeSound
    val dog = new Dog
    dog.makeSound

    val animal1 = new Cat
    animal1.makeSound
    val animal2 = new Dog
    animal2.makeSound
  }
}