def copyElements = {
  import java.util.{HashMap => JavaHashMap}
  import scala.collection.mutable.{HashMap => ScalaHashMap}
  import scala.collection.JavaConversions.mapAsScalaMap

  val source = new JavaHashMap[String, Int]
  val dest = new ScalaHashMap[String, Int]

  source.put("A", 1)
  source.put("B", 2)
  source.put("C", 3)

  for ((k, v) <- source) dest += (k -> v)
  dest
}

copyElements
