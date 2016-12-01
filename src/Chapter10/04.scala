/**
  * Created by Johnny Qian on 12/1/16.
  */

package chapter10

trait Logger {
  def log(msg: String)
}

trait ConsoleLogger extends Logger {
  override def log(msg: String) = println(msg)
}

class CryptoLogger(shift: Int = 3) extends ConsoleLogger {
  def encryptMsg(msg: String) = for(c <- msg) yield {
    if (c >='a' && c <='z')
      ((c - 'a' + shift + 26) % 26 + 'a').toChar
    else if (c >='A' && c <='Z')
      ((c - 'A' + shift + 26) % 26 + 'A').toChar
    else if (c >='0' && c <='9')
      ((c - '0' + shift + 10) % 10 + '0').toChar
    else
      c
  }

  override def log(msg: String) ={
    super.log(encryptMsg(msg))
  }
}

object Test04 extends App {
  val msg = "I came, I saw, I conquered."

  val logger1 = new CryptoLogger
  logger1.log(msg)

  val logger2 = new CryptoLogger(-3)
  logger2.log(msg)

  val logger3 = new CryptoLogger(13)
  logger3.log(msg)

  val logger4 = new CryptoLogger(13)
  val encryptedMsg = logger4.encryptMsg(msg)
  logger4.log(encryptedMsg)
}