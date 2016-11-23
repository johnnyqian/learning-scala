/**
  * Created by Johnny Qian on 11/24/16.
  */

package chapter09

import scala.io.Source

object Test07 extends App {
  val source = Source.fromFile("src/Chapter09/07.txt", "UTF-8")
  val pattern = """^(\d+)?\.\d+$""".r
  source.mkString.split("""\s+""").filter(pattern.findFirstIn(_)==None).foreach(println)
}
