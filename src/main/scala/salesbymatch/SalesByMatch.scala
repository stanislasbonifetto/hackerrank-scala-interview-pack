package salesbymatch

import java.io.PrintWriter
import scala.io.StdIn

object Result {

  /*
   * Complete the 'sockMerchant' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY ar
   */

  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    // Write your code here
    val pile: Pile = ar.foldLeft[Pile](Pile()) { (p, sock) => {
      if (p.spares.contains(sock)) {
        val pairCount = p.pairs.getOrElse(sock, 0) + 1
        val spares = p.spares.-(sock)
        val pairs = p.pairs.+(sock -> pairCount)
        Pile(spares, pairs)
      } else Pile(p.spares.+(sock), p.pairs)
    }}
    pile.pairs.foldLeft(0)((n, p) => n + p._2)
  }
  case class Pile(spares : Set[Color] = Set[Color](), pairs : Map[Color, Int] = Map[Color, Int]())

  type Color = Int
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val ar = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.sockMerchant(n, ar)

    printWriter.println(result)

    printWriter.close()
  }
}
