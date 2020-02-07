package lectures.part2oop

object AbstractDataType extends App {
  /**           Abstract Class
   * 1. Classes which contain unimplemented methods or fields are called abstract class
   * 2. Abstract class cannot be instantiated
   * 3. Traits are the ultimate "abstract" data types in scala
   * 4. Traits by default like abstract class have abstract fields and methods
   * 5. Whats special about traits is that, unlike abstract classes they can be inherited along with classes
   *    Eg. class Crocodile extends Animal with Carnivore
   * 6. Any number of Traits can be extended
   *    Eg. Class Crocodile extends Animal with Carnivore with ColdBlooded
   * 7. Abstract classes and Traits can have both abstract and non-abstract members
   * 8. How are traits different than abstract classes
   *    a. Traits cannot have constructor parameters
   *    b. A class can inherit only one class, but can inherit multiple traits
   *    c. Traits describe "behaviour", but abstract class describe "thing"
   */
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    // override keyword can be ignored
    override val creatureType: String = "K9"
    override def eat: Unit = println("crunch crunch")
  }

  /**
   *  This trait describes things which can eat animals
   */
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  // Inheriting Trait "Carnivore" along with class "Animal"
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    override def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I',m a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)
}