package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {

  def factorial(n: Int): BigInt = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)

      result
    }
  }

  // println(factorial(9))
  // println(factorial(5000)) // This will crash with StackOverFlow error

    def anotherFactorial(n: Int): BigInt ={
      @tailrec // annotation for tail recursion
      def factHelper(x: Int, accumulator: BigInt): BigInt ={
        if(x <= 1) accumulator
        else factHelper(x - 1, x * accumulator) // TAIL RECURSION = Use tail recursion as the last expression
      }

      factHelper(n, 1)
    }

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factHelper(9, 10 * 1)
  = factHelper(8, 9 * 10 * 1)
  = factHelper(7, 8 * 9 * 10 * 1)
  = ...
  = factHelper(2, 3 * 4 * ...* 9 * 10 * 1)
  = factHelper(1, 1 * 2 * 3 * ... * 10)
  = 1 * 2 * 3 * .... * 10
   */

  // println(anotherFactorial(5000))
  // WHEN YOU NEED LOOP'S USE _TAIL_ RECURSION.


  /*
    EXERCISE:
    1. Concat a string n times using tail recursion
    2. IsPrime function using tail recursion
    3. Fibonacci, using tail recursion
 */


  /*
  1. Concat a string n times using tail recursion
   */

    @tailrec
    def concatTailrec(str: String, x: BigInt, accumulator: String): String = {
      // println(accumulator)
      if (x == 0) accumulator
      else concatTailrec(str: String, x - 1, str + " " + accumulator)
    }


  /*
  = concatString("Hello", 10) = concatHelper("Hello", 10, "Hello")
  = concatHelper("Hello", 9 , "Hello Hello")
  = concatHelper("Hello", 8 , "Hello Hello Hello")
   */

  // 1. Concat a string n times using tail recursion
  //  println(concatTailrec("Hello", 3 , ""))

  /*
  2. IsPrime function using tail recursion
   */
  // Accumulator should hold the intermediate results
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(t: Int, accumulator: Boolean): Boolean = {
      if (!accumulator) false
      else if (t <= 1) true
      else isPrimeHelper(t-1, n % t != 0 && accumulator) // TAIL RECURSIVE - Use recursive calls as a LAST expression
    }

    isPrimeHelper(n/2, true)
  }

  // WHEN you need Loop's use tail recursion

  // 2. IsPrime function using tail recursion
//  println(isPrime(37))
//  println(isPrime(2003))
//  println(isPrime(37 * 17))
  println(isPrime(2003))
  println(isPrime(629))

  /*
  3. Fibonacci, using tail recursion
   */

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibTailRec(i: Int, last: Int, nextToLast: Int): Int =
      if (i >= n) last
      else fibTailRec(i + 1, last + nextToLast, last)

    if (n <= 2) 1
    else fibTailRec(2, 1, 1)

  }

  println(fibonacci(8))
}
