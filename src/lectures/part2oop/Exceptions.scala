package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // this ^^ will crash with a null pointer exception

  /**
   *    1. throwing exceptions
   */

  // val aWeiredValue: String = throw new NullPointerException
  // throwable classes extend the Throwable class.
  // Exceptions and Error are the major Throwable subtypes

  /**
   * 2. How to catch exceptions
   */
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!!")
    else 42

  try {
    // code hat might throw
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a runtime exception")
  } finally {
    // Code that wll get executed NO MATTER WHAT
    // 1. finally block is optional
    // 2. does not influence the return type of this expression
    // 3. Use finally only for side effects - Eg. If you want to log something to a text file
    println("finally")
  }

  /**
   *  3. Define your own exceptions
   */
  class MyException extends Exception
  val exception = new MyException

  throw exception

  /**   Exercises
   *   1. Crash your program with an OutOfMemoryError
   *   2. Crash with StackoOverFlowError
   *   2. PocketCalculator
   *      - add(x,y)
   *      - subtract(x,y)
   *      - multiply(x,y)
   *      - divide(x,y)
   *
   *      Throw
   *        - OverFlowException if add(x,y) exceeds Int.MAX_VALUE
   *        - UnderFlowException if subtract(x,y) exceeds Int.MIN_VALUE
   *        - MathCalculationException for division by 0
   */

//  // 1. Crash your program with an OutOfMemoryError  (OOM)
//  val array = Array.ofDim(Int.MaxValue)
//
//  // 2. Crash with StackoOverFlowError (SO)
//  def infinite: Int = 1 + infinite
//  val noLimit = infinite

  // 3. Pocket Calculator
  class OverflowWException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Divide By 0")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      // Sum of positive numbers gives -ve number when there is stackOverflow
      // eg. PocketCalculator.add(Int.MAX_VALUE + 20), gives -2147483639
      if (x > 0 && y > 0 && result < 0) throw new OverflowWException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y > 0 && result < 0) throw new OverflowWException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowWException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowWException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }

  }

  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))
}
