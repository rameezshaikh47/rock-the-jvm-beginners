package lectures.part2oop

import scala.language.postfixOps

object MethodNotation extends App {


  class Person(val name: String, favMovie: String, val age: Int = 0) {

    def likes(movie: String): Boolean = {
      // println(movie)
      movie == favMovie
    }
    def hangsOutWith(Person: Person): String = s"${this.name} hanging out with ${Person.name}"
    // method renamed
    def +(Person: Person): String = s"${this.name} hanging out with ${Person.name}"

    /**
     *  1. overload + operator
     *      mary + "the rockstar" => new person "Mary (the rockstar)
     */
    def +(nickName: String): String = s"${this.name} ($nickName)"

    def unary_! : String = s"$name what the heck!!"

    /**
     *  2. Add an age to the Person class
     *     Add a unary + operator => new person with the age + 1
     *     +mary => mary with the age incrementer
     */
    def unary_+ : Person = new Person(name, favMovie, age + 1)

    /**
     *  3. Add a "learns: method in the Person class => "Mary learns Scala"
     *     Add a learnScala method, calls learns method with "Scala"
     *     Use it in postfix notation.
     */
     def learns(language: String): String = s"$name learns $language"
     // def learnScala = learns("Scala")
     def learnsScala = this learns "Scala"

    /**
     *  4. Overload the apply method
     *      mary.apply(2) => "Mary wacthed Inception 2 times"
     */
     def apply(n: Int) = s"Mary watched $favMovie $n times"

    def isAlive: Boolean = true
    def apply(): String = s"I'm $name and my favorite movie is $favMovie"
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

  // Postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply)
  println(mary()) // equivalent

  /**
   *   EXERCISES
   *
   */

  /**
   *  1. overload + operator
   *      mary + "the rockstar" => new person "Mary (the rockstar)
   */
  println((mary + "The rockstar"))

  /**
   *  2. Add an age to the Person class
   *     Add a unary + operator => new person with the age + 1
   *     +mary => may with the age incrementer
   */
  val maryNew = +mary
  println(maryNew.age)
  println((+mary).age)

/**
  *  3. Add a "learns: method in the Person class => "Mary learns Scala"
  *     Add a learnScala method, calls learns method with "Scala"
  *     Use it in postfix notation.
  */
  println(mary learnsScala)

  /**
   *  4. Overload the apply method
   *      mary.apply(2) => "Mary wacthed Inception 2 times"
   */
  println(mary.apply(2))
}
