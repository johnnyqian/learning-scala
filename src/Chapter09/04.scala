/**
  * Created by Johnny Qian on 11/23/16.
  */

import scala.io.Source

package chapter09 {

  object Test04 extends App {
    val source = Source.fromFile("src/Chapter09/04.txt", "UTF-8")

    val pattern = """[0-9]+\.[0-9]+""".r
    val allFloatNumbers = pattern.findAllIn(source.mkString).map(_.toDouble).toArray
    println("Sum :" + allFloatNumbers.sum)
    println("Avg :" + allFloatNumbers.sum / allFloatNumbers.length)
    println("Max :" + allFloatNumbers.max)
    println("Min :" + allFloatNumbers.min)

    source.close()
  }
}
