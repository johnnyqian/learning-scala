package chapter08 {

  abstract class Item {
    def price: Double

    def description: String
  }

  class SimpleItem(val price: Double, val description: String) extends Item {

  }

  class Bundle extends Item {
    import scala.collection.mutable.ArrayBuffer

    private val items = ArrayBuffer[Item]()
    def addItem(item: Item) = {
      items += item
    }

    def price = items.map(_.price).sum
    def description = items.map(_.description).mkString(",")
  }

  object Test04 extends App {
    val b = new Bundle
    b.addItem(new SimpleItem(1.0, "Apple"))
    b.addItem(new SimpleItem(2.0, "Banana"))
    b.addItem(new SimpleItem(3.0, "Orange"))

    println(b.price)
    println(b.description)
  }

}
