package chapter08 {
  class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {
    def this(width: Int) = this(0,0,width)
    def this() = this(0,0,0)
  }

  object Test07 extends App {
    val s1 = new Square(1,1,4)
    println(s1)

    val s2 = new Square(4)
    println(s2)

    val s3 = new Square()
    println(s3)
  }
}