package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I'm learning Scala"

  // Java based string methods
  println(str.charAt(2))
  println(str.substring(7, 12))
  println(str.split(" ").toList)
  println(str.toLowerCase)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.length)


  // Scala specific string functions
  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println('a' + aNumberString + 'z')
  println('a' + aNumber + 'z') // Convert's string to Integer o/p is 221
  // println('a' +: aNumber :+ 'z') -- This does not work, cannot concat String and Integer's with +:
  println(str.reverse)
  println(str.take(2))

  /*
  Scala specific: String Interpolator's
   */

  // S- Interpolator's
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age year's old"
  val anotherGreeting = s"Hello, my name is $name and I'm turning ${age + 1} years old."
  println(anotherGreeting)

  // F- Interpolator's - Similar to printf format
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw- Interpolator's
  println(raw"This is a \n newline")
  val escape = "This is a \n newline"
  println(escape)

}
