package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  println(aFunction("Hello", 3))

  def aParameterLessFunction(): Int = 47
  println(aParameterLessFunction())
  println(aParameterLessFunction)

  //Recursive functions
  // 1. Recursive functions require return type to be specified
  // 2. When you need loops use recursion
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else
      aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("Hello ", 3))

  // Function with Unit return type - Function with side-effect
  def aFunctionWithSideEffect(aString: String) = println(aString)

  // Code block allow you to define axillary functions
  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int) = a + b

    aSmallFunction(n, n-1)
  }

  println(aBigFunction(4))

  /*
    1. A greeting functions (name, age) => "Hi, my name is $name and I am $age year old"
  */
  def greetingMsg(name: String, age: Int): String =
    "Hi, my name is " + name + " and I'm " + age + " years old"

  println(greetingMsg("Joy", 30))

  /*
    2. Factorial functions 1 * 2 * 3 * .... * n
   */
  def aFactorial(n: Int): Int = {
    if (n == 1) n
    else
      n * aFactorial(n-1)
  }

  println(aFactorial(1))

  /*
  A Fibonacci function
   */
  def aFibonacci(n: Int): Int = {
    if (n <= 2)
      1
    else
      aFibonacci(n-1) + aFibonacci(n-2)
  }

  println(aFibonacci(8))

  /*
  Test if a number is prime
   */
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)

  }

  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))
}
