package excersises

// TODO: Complete program with case classes

/**     Single linked list
 *   head = first element of the list
 *   tail = remainder of the list
 *   isEmpty = is this list empty
 *   add(int) = new list with this element added
 *   toString = a string representation of the list
 */
abstract class MyList[+A] {
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  // Polymorphic call
  override def toString: String = "[" + printElements + "]"
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  override def printElements: String = ""

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  override def printElements: String = {
    if(t.isEmpty) "" + h
//       [1, [2, [3, [4, [5, empty]]]]]
    else h + " " + t.printElements
  }
}

object ListTest extends App {
//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.head)
//  println(list.add(4).head)
//  println(list.isEmpty)
//  println(list)
//  // Polymorphic call
//  println(list.toString)

  val listOfIntegers: MyList[Int] = new Cons(2, new Cons(3, new Cons(4, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}