import java.io.PrintWriter
import scala.io.Source

package chapter09 {

  object Test01 extends App {

    // check working directory
//    println(new java.io.File(".").getCanonicalPath)
//
//    import sys.process._
//    "pwd" !

    val source = Source.fromFile("src/Chapter09/01.txt", "UTF-8")
    val lines = source.getLines.toArray.reverse

    val out = new PrintWriter("src/Chapter09/01.out")
    out.print(lines.mkString("\n"))
    out.close()

    source.close()
  }
}