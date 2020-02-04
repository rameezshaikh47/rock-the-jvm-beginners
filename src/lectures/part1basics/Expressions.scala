package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSIONS
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  var aVariable = 2
  aVariable += 3 // also works with -=, *=, /=
  // (Changing the value of varibales is called side effects)
  println(aVariable)

  // INSTRUCTIONS (DO) vs EXPRESSIONS (Has a VALUE and/or TYPE)

  // IF EXPRESSION
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue)

  // In Scala the IF Expression give back a value,
  // unlike in Java or Python IF condition DO something

  println(if(aCondition) 5 else 3)

  // There are loop in scala, but the use is discouraged
  var i = 0
  while (i < 10){
    println(i)
    i += 1
  }

  // While loops in scala are side-effects they return Unit
  // Example
  var j = 0
  val aWhile = while (j < 10){
    println(j)
    j += 1
  }

  // Everything in scala is an Expression
  val aWiredValue = (aVariable == 3)
  // Value of aWiredValue is Unit which is eqvivalent to void in other languages
  // () is the only value a Unit type can hold
  // Side effects in scala a actually expressions returning Unit
  println(aWiredValue)

  // Side-effects : println(), while(), reassigning of var's

  // code block - special kind on expressions because they have special properties
  // 1. Code block is an expression
  // 2. The value of the block is the value of its last expression
  // 3. Anything declared within a code block has the scope with the code block
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }

  // Exercises
  // 1. difference between "Hello Scala" and println("Hello Scala")
     // "Hello Scala" - is a value of type String that is a string literal
     // println("Hello Scala") - is a expression which is a side effect of type Unit

  // 2. whats the value of
  val someValue = {
    2 < 3
  }
    // Ans: true

  // 3. whats the value of
  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
   // Ans: 42

}
