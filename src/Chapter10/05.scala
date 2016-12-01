/**
  * Created by Johnny Qian on 12/1/16.
  */

package chapter10

import java.beans.{PropertyChangeEvent, PropertyChangeListener, PropertyChangeSupport => JavaPropertyChangeSupport}
import java.awt.Point

trait PropertyChangeSupport {
  val pcs =  new JavaPropertyChangeSupport(this)

  def addPropertyChangeListener(listener: PropertyChangeListener): Unit = {
    pcs.addPropertyChangeListener(listener)
  }

  def removePropertyChangeListener(listener:PropertyChangeListener) {
    pcs.removePropertyChangeListener(listener)
  }

  def firePropertyChange(propertyName: String, oldValue:Any, newValue:Any) {
    pcs.firePropertyChange(propertyName, oldValue, newValue)
  }
}

class PropertyChangeSupportedPoint(a: Int = 0, b: Int = 0) extends Point(a, b) with PropertyChangeSupport {
  override def move(x: Int, y: Int): Unit = {
    val oldX = this.x
    val oldY = this.y

    super.move(x, y)

    if(oldX != x)
      firePropertyChange("x", oldX ,x)
    if(oldY != y)
      firePropertyChange("y", oldY ,y)
  }
}

object Test05 extends App {
  val p = new PropertyChangeSupportedPoint(1,2)
  p.addPropertyChangeListener(new PropertyChangeListener {
    override def propertyChange(evt: PropertyChangeEvent): Unit = {
      printf("%s: %s => %s\n", evt.getPropertyName, evt.getOldValue, evt.getNewValue)
    }
  })

  p.move(2,2)
  p.move(3,3)
  p.move(3,4)
}