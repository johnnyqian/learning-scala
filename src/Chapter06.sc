// 1
object Conversions {
  def inchesToCentimeters(value: Double) = {
    value * 2.54 // 1英寸(in)=2.54厘米(cm)
  }

  def gallonsToLiters(value: Double) = {
    value * 3.7854118 // 1美制加仑(us gal)=3.7854118升(l)
  }

  def milesToKilometers(value: Double) = {
    value * 1.609344 // 1英里(mi)=1.609344千米(km)
  }
}

// 2
class UnitConversion(val factor: Double) {
  def convert(value: Double) = {
    value * factor
  }
}

object InchesToCentimeters extends UnitConversion(2.54)
InchesToCentimeters.convert(10)

object GallonsToLiters extends UnitConversion(3.7854118)
GallonsToLiters.convert(10)

object MilesToKilometers extends UnitConversion(1.609344)
MilesToKilometers.convert(10)

// 3
object Origin extends java.awt.Point {
  def apply() = new java.awt.Point()
}
Origin()

// 4
class Point(val x:Int, val y:Int) {

}
object Point {
  def apply(x: Int, y: Int) = new Point(x,y)
}
val p = Point(3,4)
p.x
p.y

// 5
object ReverseArgs extends App {
  println(args.reverse.mkString(" "))
}

// 6
object Suits extends Enumeration {
  val club = Value("♣")
  val diamond = Value("♦")
  val heart = Value("♥")
  val spade = Value("♠")
}
Suits.club
Suits.diamond
Suits.heart
Suits.spade

// 7
object Suits2 extends Enumeration {
  type Suit = Value

  val club = Value("♣")
  val diamond = Value("♦")
  val heart = Value("♥")
  val spade = Value("♠")

  def isRed(card: Suit) = {
    card == heart || card == diamond
  }
}

// 8
object RGBCubeColors extends Enumeration {
  val R = Value(0xff0000, "Red")
  val G = Value(0x00ff00, "Green")
  val B = Value(0x0000ff, "Blue")
  val RG = Value(0xffff00, "Yellow")
  val RB = Value(0xff00ff, "Magenta") // 洋红
  val GB = Value(0x00ffff, "Cyan") // 青色
  val RGB = Value(0xffffff, "White")
  val Black = Value(0x000000, "Black")
}
for( c <- RGBCubeColors.values ) println("0x%06x: %s".format(c.id, c))
