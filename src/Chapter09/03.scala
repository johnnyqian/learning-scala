/**
  * Created by Johnny Qian on 11/23/16.
  */

import scala.io.Source

package chapter09 {

  object Test03 extends App {
    Source.fromFile("src/Chapter09/03.txt", "UTF-8").mkString.split("\\s+").filter(_.length > 12).distinct.foreach(println)
  }
}