/**
  * Created by Johnny Qian on 12/1/16.
  */

package chapter10

trait AuditLogger{
  val level: String

  def log(msg: String)
}

trait UserRepository {
  val defaultId: Int = 1
  def getUserById(id: Int) = id match {
    case 1 => ("johnny", 24)
    case _ => ("admin", 30)
  }
}

class UserService extends UserRepository with AuditLogger {
  override val level: String = "Info"

  override def log(msg: String) = {
    println(s"$level: get user ($msg) from db.")
  }

  override def getUserById(id: Int) = {
    val user = super.getUserById(if (id < 1) defaultId else id)
    log(user._1 + "," + user._2)
    user
  }
}

object Test07 extends App {
  val service = new UserService

  service.getUserById(0)
  service.getUserById(2)
}