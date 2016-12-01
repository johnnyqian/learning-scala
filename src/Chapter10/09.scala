/**
  * Created by Johnny Qian on 12/1/16.
  */

package chapter10

import java.io.{BufferedInputStream, FileInputStream, InputStream}

object Test09 extends App {
  trait Logger {
    def log(msg: String)
  }

  trait BufferedInput extends Logger {
    this: InputStream =>

    override def log(msg: String): Unit = {
      println(msg)
    }

    val size: Int = 100
    private val buffer = new Array[Byte](size)
    private var cur = 0
    private var readsize = 0

    override def read(): Int = {
      if(cur >= readsize) {
        cur = 0 // reset cursor
        readsize = read(buffer, 0, size)
        if (readsize == -1) // there is no more data because the end of the stream has been reached
          return -1

        log("\nbuffered %d bytes".format(readsize))
      }

      cur += 1
      buffer(cur - 1)
    }
  }

  val txtFile = getClass.getResource("/sample.txt")
  val file = new FileInputStream(new java.io.File(txtFile.getPath)) with BufferedInput

  var byte = file.read()
  while (byte != -1){
    print(byte.toChar)
    byte = file.read()
  }
}