/**
  * Created by Johnny Qian on 12/1/16.
  */

package chapter10

import java.io.{FileInputStream, InputStream}

class IterableInputStream(is: InputStream) extends InputStream with Iterable[Byte] {
  override def read(): Int = is.read

  override def iterator: Iterator[Byte] = new Iterator[Byte] {
    override def hasNext: Boolean = is.available > 0

    override def next(): Byte = is.read.toByte
  }
}

object Test10 extends App {
  val txtFile = getClass.getResource("/sample.txt")
  val it = new IterableInputStream(new FileInputStream(new java.io.File(txtFile.getPath))).iterator

  it.map(_.toChar).foreach(print(_))
}