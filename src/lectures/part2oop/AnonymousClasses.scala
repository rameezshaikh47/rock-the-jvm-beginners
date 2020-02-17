package lectures.part2oop

object AnonymousClasses extends App {

  /**
   *   Anonymous Classes: We can instantiate types and override fields or methods on the spot
   *    Rules:
   *      1. Pass in required constructor arguments if need Eg. as in Person class
   *      2. Implement all abstract fields/methods
   *
   *   Works for traits and classes (weather they are abstract or not)
   */


  abstract class Animal {
    def eat: Unit
  }

  // anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahahaha")
  }

  /*  Equivalent with

      class AnonymousClasses$$anon$1 extends Animal {
        override def eat: Unit = println("ahahahahahaha")
      }

      val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  // Anonymous class work for both abstract and non-abstract data types
  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, How can I help?")
  }

  val jim: Person = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, How can I help?")
  }

}
