// 1
val products = Map("A" -> 10, "B" -> 20, "C" -> 30)
val productsWithDiscount = for((k,v) <- products) yield (k, v * 0.9)

// 2 please check the 'Make project' in the Worksheet in order to read the txt file from resource
val txtFile = getClass.getResource("/sample.txt")
val in = new java.util.Scanner(new java.io.File(txtFile.getPath))
val wordCount = new collection.mutable.HashMap[String, Int]
while(in.hasNext()) {
  val word = in.next()
  wordCount(word) = wordCount.getOrElse(word, 0) + 1
}
wordCount.mkString(",")

// 3
val in2 = new java.util.Scanner(new java.io.File(txtFile.getPath))
var wordCount2 = new collection.immutable.HashMap[String, Int]
while(in2.hasNext){
  val word = in2.next()
  wordCount2 += word -> (wordCount2.getOrElse(word, 0) + 1)
}
wordCount2.mkString(",")

// 4
val in3 = new java.util.Scanner(new java.io.File(txtFile.getPath))
var wordCount3 = collection.immutable.SortedMap[String, Int]()
while(in3.hasNext){
  val word = in3.next()
  wordCount3 += word -> (wordCount3.getOrElse(word, 0) + 1)
}
wordCount3.mkString(",")

// 5
import collection.JavaConversions.mapAsScalaMap

val in4 = new java.util.Scanner(new java.io.File(txtFile.getPath))
val wordCount4:collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
while(in4.hasNext){
  val word = in4.next()
  wordCount4(word) = wordCount4.getOrElse(word, 0) + 1
}
wordCount4.mkString(",")

// 6
val dates = new collection.mutable.LinkedHashMap[String, Int]
dates += "Monday" -> java.util.Calendar.MONDAY
dates += "Tuesday" -> java.util.Calendar.TUESDAY
dates += "Wednesday" -> java.util.Calendar.WEDNESDAY
dates += "Thursday" -> java.util.Calendar.THURSDAY
dates += "Friday" -> java.util.Calendar.FRIDAY
dates += "Saturday" -> java.util.Calendar.SATURDAY
dates += "Sunday" -> java.util.Calendar.SUNDAY
dates.mkString(",")

// 7
import collection.JavaConversions.propertiesAsScalaMap

val props:collection.Map[String, String] = System.getProperties
var maxNameLength = 0
for((k, _) <- props) {
  if(k.length > maxNameLength)
    maxNameLength = k.length
}

for((k,v) <- props) {
  print(k)
  print(" " * (maxNameLength - k.length))
  print("|")
  println(v)
}

// 8
def minmax(values: Array[Int]) = {
  (values.min, values.max)
}
minmax(Array(1,2,3,4,5))

// 9
def lteqgt(values: Array[Int], v: Int) ={
  var lt, eq, gt = 0
  for(k <- values){
    if(k > v)
      gt += 1
    else if(k < v)
      lt += 1
    else
      eq += 1
  }

  (lt, eq, gt)
}
lteqgt(Array(1,2,3,4,5), 3)

// 10
"Hello".zip("World")
"Hello".zip("Java")
"Learning".zip("Scala")