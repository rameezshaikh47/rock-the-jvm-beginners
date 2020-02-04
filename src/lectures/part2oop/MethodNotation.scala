package lectures.part2oop

object MethodNotation extends App {

  class Person(val name: String, favMovie: String) {

    def likes(movie: String): Boolean = {
      // println(movie)
      movie == favMovie
    }
    def hangsOutWith(Person: Person): String = s"${this.name} hanging out with ${Person.name}"
    // method renamed
    def +(Person: Person): String = s"${this.name} hanging out with ${Person.name}"
    def unary_! : String = s"$name what the heck!!"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // equivalent to
  println(mary likes "inception")
  // syntax: Object.Method(parameter) ==> Object Method "Parameter"
  // Infix notation or operator notation (Syntactic sugar)
  // Only methods with single parameter can be called in this fashion

  // "Operator" - methods in Scala
  val tom = new Person("Tom", "Fight Club")
  println(tom hangsOutWith mary)
   // Using "+" method
  println(tom + mary)
  println(mary + tom)
  println(tom.+(mary))

  // All operators are methods
  println(1.+(2))
  println(1 + 2)

  // prefix notations
  val x = -1    // equivalent 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with -, +, !, ~

  println(!mary)
  println(mary.unary_!)

}
