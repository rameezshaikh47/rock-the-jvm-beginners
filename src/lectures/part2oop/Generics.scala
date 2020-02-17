package lectures.part2oop

/**
 *  1. Generic types are defined with [], this allows a class/traits to accept different data types
 *
 */

object Generics extends App {

  // MyList with type A
  class MyList[+A] {
    // Type 'A' can be used here
    def add[B >: A](element: B): MyList[B] = ???
  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Multiple generic type parameters
  class MyNewList[Key, Value]

  /**
   *  Generic methods
   */
  object MyList {
    def empty[A]: MyList[A] = ???

  }

  val myEmptyList = MyList.empty[Int]

  /**
   *  Variance Problem
   */
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // If Cat extends Animal, then list Cat also extends list of Animal?

  // 3 possible answers for this
  // 1. Yes - List[Cat] extends ist[Animal], this is called COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // This mean a dog can be added to a cat list and this would pollute the list
  // animalList.add(new dog) ???

  // 2. No - List[Cat] and List[Animal] are 2 different things, this is called INVARIANT
  class InvariantList[A]
  // Invarient classes are each one on its own world and you cannot substitute one for another
  // val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]
  // above will give error,
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell, NO!! CONTRAVARIENCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  /**
   *  Bounded Types - All you to use your Generic classes only for certain types, that are either a
   *  sub-class of a different type or super class of a different type
   *
   *  Upper Bounded types and Lower Bounded types
   *
   *  Bounded types solve variance problem
   */

  // class Cage[A <: Animal](animal: A) // class Cage only excepts type parametes A which are sub-types of Animal
  //val cage = new Cage(new Dog)

  // class Car
  // val newCage = new Cage(new Car) // this is not allowed
  // Generic types need proper bounded types

  class CageNew[A >: Animal](animal: A) //Lower bounded types only allow parameter A which is a Super type of Animal

}
