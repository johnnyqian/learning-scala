package chapter08 {
  class Point(val x: Double, val y: Double){

  }

  class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y) {

  }

  object Test05 extends App {
    val p = new LabeledPoint("Black Thursday", 1929, 230.07)

    println(p.label)
    println(p.x)
    println(p.y)
  }
}