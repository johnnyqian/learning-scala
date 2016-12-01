/**
  * Created by Johnny Qian on 11/28/16.
  */

package chapter10

import java.awt.Point

class OrderedPoint(a: Int, b: Int) extends Point(a,b) with scala.math.Ordered[Point] {
  override def compare(that: Point): Int = {
    if (this.x <= that.x && this.y < that.y) - 1
    else if (this.x == that.x && this.y == that.y) 0
    else 1
  }
}

object Test02 extends App {
  val x1 = new OrderedPoint(1, 1)
  val x2 = new OrderedPoint(1, 2)
  val x3 = new OrderedPoint(2, 1)
  val x4 = new OrderedPoint(2, 1)

  assert(x1 < x2)
  assert(x3 > x2)
  assert(x4 == x3)
}
