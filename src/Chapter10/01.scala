/**
  * Created by Johnny Qian on 11/28/16.
  */

package chapter10

trait RectangleLike { this: java.awt.geom.Ellipse2D =>
  def translate(x: Double, y: Double) = {
    setFrame(getX + x, getY + y, getWidth, getHeight)
  }

  def grow(w: Double, h: Double) = {
    setFrame(getX, getY, getWidth + w, getHeight + h)
  }

  override def toString = "[%.2f, %.2f, %.2f, %.2f]".format(getX, getY, getWidth, getHeight)
}

object Test01 extends App {
  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike

  egg.translate(10, -10)
  egg.grow(10, 20)

  print(egg)
}