import java.io.PrintWriter
import scala.io.Source

package chapter09 {

  object Test02 extends App {
    val source = Source.fromFile("src/Chapter09/02.txt", "UTF-8")
    val table = ( for (line <- source.getLines) yield line.split('\t') ).toArray

    var columnWidth = new Array[Int](table.head.length)
    for(row <- table){
      for(i <- 0 until row.length){
        val stringLength = row(i).length
        if(stringLength > columnWidth(i)) {
          columnWidth(i) = stringLength
        }
      }
    }

    val out = new PrintWriter("src/Chapter09/02.out")
    for(row <- table){
      for(i <- 0 until row.length){
        out.printf(s"%-${columnWidth(i) + 1}s", row(i))
      }
      out.println
    }

    out.close()
    source.close()
  }
}