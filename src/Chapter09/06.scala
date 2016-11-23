/**
  * Created by Johnny Qian on 11/23/16.
  */

package chapter09 {

  import scala.io.Source

  object Test06 extends App {
    val test = "like this, maybe with \" or \\"

    val source = Source.fromFile("src/Chapter09/06.scala", "UTF-8").mkString
    val pattern = """\\\"""".r
    pattern.findAllIn(source).foreach(println)
  }
}
