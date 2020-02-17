package lectures.part2oop

object Inheritance extends App {
  /**                         Inheritance
   *                          -----------
   * 1. extending a class means inheriting all non-private fields and methods
   * 2. cat is called sub-class of Animal and Animal is called super-class of Cat
   * 3. Scala offers single class inheritance that is only one class can be inherited at a time
   * 4. PRIVATE methods or fields are accessible within the class they are declared in
   * 5. PROTECTED allows the methods or fields to used in Sub-classes
   * 6. PRIVATE, PROTECTED & PUBLIC (default) are called access modifiers
   *
   *
   */
  class Animal {
    val creatureType = "Wild"
    protected def eat = println("nommom")
    def sounds = println("Makes some sound!!")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  // cat.eat ==> Not accessible outside the class or sub-class since its protected
  cat.crunch // her eat() is accessible through the sub-class Cat

  /**                   Constructors
   *  1. Defining a class also defined its constructor
   *  2. JVM needs to call the constructor of parent class first, so when extending you need to
   *     specify the parameters of the parent class Eg. "extends Person(name, age) or
   *     parameters of Auxiliary constructors Eg. "extends Person(name)" uses auxiliary constructor
   *     "def this(name: String) = this(name, 0)"
   *
   */

  class Person(name: String, age: Int) {
    // Auxiliary constructor
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  // extending using Auxiliary constructor
  // class Adult(name: String, age: Int, idCard: String) extends Person(name)

  /**               Overriding
   * 1. Overriding works for methods as it works for val and var
   * 2. Fields can be overridden in the class constructors
   *    Eg. class Dog(override val creatureType: String) extends Animal
   * 3. Overriding VS Overloading
   *    Overriding => Means supplying different implementations in derived classes
   *    Overloading => Means supplying different methods with different signatures with same names in same class
   * 4. super => Super is used when you want to reference a method or field from a parent class
   * 5. Preventing overrides
   *               a. use "final", final keyword will prevent derived class from overriding method/field
   *               b. final can used on a class itself, this will prevent the class from getting extended
   *               c. sealing the class, using "sealed" keyword on class means "extend class in this file only
   *               but prevents extension in other files
   */
  class Dog(override val creatureType: String) extends Animal{
    // Overriding val
    // override val creatureType: String = "Domestic"
    // Overriding method
    override def eat = {
      println("Crunch Crunch Crunch")
      // using super to reference method from parent class
      super.eat
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (in a broad sense: Polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.sounds

 }
