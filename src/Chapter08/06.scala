package chapter08 {
  abstract class Shape {
    def centerPoint: Point

    override def toString = "x = %f, y = %f".format(centerPoint.x, centerPoint.y)
  }

  class Rectangle(val topLeft: Point, val bottomRight: Point) extends Shape {
    def centerPoint: Point = {
      new Point((bottomRight.x + topLeft.x)/2 , (bottomRight.y + topLeft.y)/2)
    }
  }

  class Circle(val centerPoint: Point, val radius: Double) extends Shape {

  }

  object Test06 extends App {
    val r = new Rectangle(new Point(1,1), new Point(3,3))
    println(r)

    val c = new Circle(new Point(2,2), 1.0)
    println(c)
  }
}