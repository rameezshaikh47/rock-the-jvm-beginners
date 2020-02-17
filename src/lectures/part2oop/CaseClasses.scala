package lectures.part2oop

/**  Case Class
 *   Are quick way of defining lightweight data structures with little boiler-plate
 *
 */
object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)   // this is not valid if he class is not case class


  // 2. Sensible toString
  // println(instance) = println(instance.toString) // Syntactic sugar
  println(jim)

  // 3. Equals and hashCode implementation Out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case Classes have handy copy method
  //    Copy creates a new instance of the named class, copy method also receives parameters
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. Case classes have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)  // the new keyword is not required when creating a new instance of case class

  // 6. case classes are serializable -
  // handy while dealing with distributed frameworks like Akka

  // 7. CC's have have extractor, which means CC's can be used in PATTERN MATCHING

  // 8. Case Object - This acts like a case class except its an Object
  case object UnitedKingdom {
    def name: String = "The UK of GD and NI"
  }

}
