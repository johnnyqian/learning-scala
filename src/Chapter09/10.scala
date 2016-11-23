/**
  * Created by Johnny Qian on 11/24/16.
  */

package chapter09

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}
import scala.collection.mutable.ArrayBuffer

object Test10 extends App {

  case class Person(val name: String) extends Serializable {
    val friends = new ArrayBuffer[Person]

    def addFriend(p: Person) {
      friends += p
    }

    def isFriendOf(p: Person): Boolean = {
      friends.contains(p)
    }
  }

  val tom = Person("tom")
  val jerry = Person("jerry")
  val johnny = Person("johnny")

  tom.addFriend(johnny)
  jerry.addFriend(johnny)

  val persons = Array(tom, jerry, johnny)

  val out = new ObjectOutputStream(new FileOutputStream("src/Chapter09/10.obj"))
  out.writeObject(persons)
  out.close()

  val in = new ObjectInputStream(new FileInputStream("src/Chapter09/10.obj"))
  val Array(_tom,_jerry,_johnny) = in.readObject().asInstanceOf[Array[Person]]

  assert(_tom isFriendOf _johnny)
  assert(_jerry isFriendOf _johnny)
  // assert(_tom isFriendOf _jerry)
}
