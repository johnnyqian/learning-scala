import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable.{HashMap => ScalaHashMap}
import scala.collection.JavaConversions.mapAsScalaMap

val source = new JavaHashMap[String, Int]
val dest = new ScalaHashMap[String, Int]

source.put("A", 1)
source.put("B", 2)
source.put("C", 3)

source.foreach(kv => dest += (kv._1 -> kv._2))
dest
dest.clear()

for (key <- source.keySet.toArray(new Array[String](0)))
  dest(key) = source.get(key)
dest
dest.clear()

for((k, v) <- source) dest += (k -> v)
dest
