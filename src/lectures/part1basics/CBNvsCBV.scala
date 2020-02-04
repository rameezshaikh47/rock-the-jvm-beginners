package lectures.part1basics

object CBNvsCBV extends App {


  def callByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // "=>", indicates the function should be called by value
  def callByName(x: => Long): Unit = {
    println("by name:  " + x)
    println("by name:  " + x)
  }

  // In call by value the expression "System.nanoTime" is first evaluated and then passed
  // to the function
  callByValue(System.nanoTime())

  // In call by name the expression "System.nanoTime" is passed to the function
  // and evaluated each time the function is used - lazily evaluated
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  /*
  printFirst(infinite(), 34) - Will crash because while printing "x" printFirst will try to evaluate
  infinite() and leads to stackOverFlow
   */
  //printFirst(infinite(), 34)

  /*
  printFirst(34, infinite()) - will not crash because "y" (infinite()) is never evaluated beacuse of call by
  name ("=>"), since on "x" is printed by printFirst()
   */
  printFirst(34, infinite())
}
