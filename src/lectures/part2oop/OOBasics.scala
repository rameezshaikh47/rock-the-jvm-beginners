package lectures.part2oop

object OOBasics extends App {

  // Instantiate class
  val person = new Person("Jhon", 29)
  // println(person.name) - cannot be accessed as it's a class parameter
  println(person.age)
  println(person.x)
  person.greet("Denial")
  person.greet()
}


// Class definitions - can sit at top level code (outside object)
class Person(name: String, val age: Int = 0) {
// 1. Constructor ("Person(name: String, age: Int)")
//        - Say's every single instance of person should be created by passing a name and age
// 2. name and age - are class parameter and not CLASS FIELD's (i.e cannot be accessed as person.name)
// 3. Class parameters can be converted to class fields by adding val/var
//        - in Person class, "name" is a class parameter and "age" is a class field

  // Class body

  // You can define val and var's - can be accessed as person.x
  val x = 2

  // You can have expressions - Expressions and evaluated each time the class is instantiated
  println(1 + 3)

  // You can have method's and functions
  def greet(name: String): Unit = println(s"${this.name} say's: Hi $name")
  // ${this.name} => implies class parameter (John)


  // Overloading - Method's with same name but different signatures
  def greet(): Unit = {
    println(s"Hi, I'm $name")
    println(s"Hi, I'm ${this.name}")
  }

  // multiple constructor's
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  author.fullName()
  novel.authorAge()
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposter))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print

}

/*
  Novel and a writer class

  Writer: first name, surname, year
    - method - which returns fullname

  Novel: name, year of release, author - which instance of type Write
    - methods, authorAge - age of the author at the time of release
    - isWrittenBy(author)
    - copy (new year of release) = new instance of Novel
 */

class Writer(firstName: String, surName: String, val year: Int) {
  def fullName(): Unit = println(s"Author's full name is $firstName $surName")
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Unit = println(s"Author's age at the time of release is ${yearOfRelease - author.year}")
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)
}

/*
  Counter class
  - Receives a Int
  - method which return the current count
  - method to increment/decrement the counter by 1 and return a new Counter
  - overload inc/dec to receive the amount by which counter is incremented/decremented
 */

class Counter(val num: Int = 0) {

  def returnCounter(): Int = this.num

  def inc(): Counter = {
    println("Incrementing...")
    new Counter(this.num + 1)
  }

  def dec(): Counter =  {
    println("Decrementing...")
    new Counter(this.num - 1)
  }

//  def inc(newNum: Int): Counter = new Counter(this.num + newNum)
//  def dec(newNum: Int): Counter = new Counter(this.num - newNum)

  def inc(n: Int): Counter = {
    if(n <= 0) this
      // Use recursion - call method inc() then inc(n-1)
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if(n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(num)
}