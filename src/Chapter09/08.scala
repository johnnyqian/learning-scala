/**
  * Created by Johnny Qian on 11/24/16.
  */

package chapter09

import scala.io.Source

object Test08 extends App{
  val source = Source.fromURL("http://www.bing.com/images/search?q=scala&go=Search", "UTF-8")

  val pattern = """<img([^>]+)src="([^"]+)""".r

  for(pattern(k,v) <- pattern.findAllIn(source.mkString)){
    println(s"$v")
  }
}
