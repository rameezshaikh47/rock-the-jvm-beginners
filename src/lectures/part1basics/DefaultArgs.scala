package lectures.part1basics

object DefaultArgs extends App {

  // acc is given a default value
  def tailFact(n: Int, acc: Int = 1): Int =
    if(n <= 1) acc
    else tailFact(n-1, n * acc)

  val fact10 = tailFact(10)

  def savePicture(format: String = "jpeg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture")
  savePicture(width = 800)

  /*
    1. Pass in every leading argument
    2. Use named arguments
   */

  savePicture(width = 800, height = 1092, format = "bmp")
}
