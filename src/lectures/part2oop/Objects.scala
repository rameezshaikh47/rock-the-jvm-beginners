package lectures.part2oop

object Objects {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNTIONALITY ("static")
  // To use class level functions in scala we use Objects
  // Scala object is a SINGLETON INSTANCE
  // When an Object is defined, its type is defined and its only instance
  object Person { // type is Person and it has only one instance
    // "STATIC"/"CLASS" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // FACTORY PATTERN's
    // factory method - Because its soul purpose is to build new person given some inputs
    // def from(mother: Person, father: Person): Person = new Person("Bobbie")
    // often these factory methods are called in a convenient way with apply
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // Instance-level functionality (Regular Instance)
  }

  def main(args: Array[String]): Unit = { // extends App can be used instead
  // The pattern of writing class and object with the same name is called COMPANIONS
  // The object and class Person are called COMPANIONS because they have same SCOPE and same NAME
    // Companions can access each others private members
  println(Person.N_EYES)
  println(Person.canFly)

  // Instances of class Person
  val person1 = new Person("person1")
  val person2 = new Person("person2")
  println(person1 == person2) // this will be false as these are 2 different instances

  // Scala objects are SINGLETON INSTANCE
  val mary = Person
  val john = Person
  println(mary == john) // = true because its a single instance


  // val bobbie = Person.from(person1, person2)
  val bobbie = Person.apply(person1, person2)
  // This can be also called as
  val bobbie1 = Person(person1, person2)

    println(bobbie)
    println(bobbie1)
    println(bobbie == bobbie1)
  // Scala Applications = Scala object with
  // def main(args: Array[String]) : Unit ==> extends App

  }
}
