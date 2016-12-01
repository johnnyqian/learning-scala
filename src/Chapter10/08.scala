/**
  * Created by Johnny Qian on 12/1/16.
  */

package chapter10

import java.io.{BufferedInputStream, FileInputStream, InputStream}

trait BufferedInput {
  this: InputStream =>

  val size: Int = 100
  val buffer = new BufferedInputStream(this, size)
  override def read(): Int = buffer.read
}

object Test08 extends App {
  val txtFile = getClass.getResource("/sample.txt")
  val file = new FileInputStream(new java.io.File(txtFile.getPath)) with BufferedInput

  var byte = file.read()
  while (byte != -1){
    print(byte.toChar)
    byte = file.read()
  }

  // print(Iterator.continually(file.read).takeWhile(_ != -1).map(_.toChar).mkString)
}