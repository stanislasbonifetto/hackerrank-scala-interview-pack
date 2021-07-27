package jumpingontheclouds

import java.io.PrintWriter
import scala.io.StdIn

object Result {

  /*
   * Complete the 'jumpingOnClouds' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY c as parameter.
   */

  def jumpingOnClouds(c: Array[Int]): Int = {
    c match {
      case Array() => 0
      case Array(_, _*) => countJumping(clouds = c.drop(1))
    }
  }

  private def countJumping(jumps: Int = 0, clouds :Array[Int]): Int = {
    clouds match {
      case Array() => jumps
      case Array(1) => jumps
      case Array(0) => jumps + 1
      case Array(_,0, _*) => countJumping(jumps + 1, clouds.drop(2))
      case Array(0,1, _*) => countJumping(jumps + 1, clouds.drop(1))
      case Array(1,1, _*) => 0
    }
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val c = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.jumpingOnClouds(c)

    printWriter.println(result)

    printWriter.close()
  }
}