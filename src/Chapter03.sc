// 1
import util.Random
def genArr(n: Int) : Array[Int] = {
  val seq =
    for(i <- 1 to n)
      yield new Random().nextInt(n)
  seq.toArray
}
genArr(10)

def genArr2(n: Int) : Array[Int] = {
  val arr = new Array[Int](n)
  for(i <- 0 until n)
    arr(i) = new Random().nextInt(n)
  arr
}
genArr2(10)

// 2
val arr = Array(1,2,3,4,5)
for(i <- 0 until (arr.length -1, 2)) {
  val tmp = arr(i)
  arr(i) = arr(i+1)
  arr(i+1) = tmp
}
arr

// 3
val arr2 =  Array(1,2,3,4,5)
val result =
  for(i <- 0 until arr2.length) yield {
    if (i == (arr2.length -1))
      arr2(i)
    else if(i % 2 == 0) {
      arr2(i+1)
    }
    else
      arr2(i-1)
  }
result.toArray

// 4
import collection.mutable.ArrayBuffer
val arr3 = Array(1, -1, 2, -2 , 6, 0, -3, 3, 0, 4, -4)
val arrBuffer = new ArrayBuffer[Int]()
arrBuffer ++= (for(i <- arr3 if i > 0) yield i)
arrBuffer ++= (for(i <- arr3 if i == 0) yield i)
arrBuffer ++= (for(i <- arr3 if i < 0) yield i)
arrBuffer.toArray

// 5
val arr4 = Array(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)
arr4.sum / arr4.length

// 6
val arr5 = Array(1,2,3,4,5)
arr5.reverse

val arrBuffer2 = ArrayBuffer(1,2,3,4,5)
arrBuffer2.reverse

// 7
val arr6 = Array(1,2,3,4,5,1,2,3,4,5)
arr6.distinct

// 8
val arrBuffer3 = ArrayBuffer(-1, 1, 2, 3, 4, -1, -3, 5)
val indexes = for(i <- 0 until arrBuffer3.length if arrBuffer3(i) <0) yield i
val newIndexes = indexes.reverse.dropRight(1)
for(i <- newIndexes) arrBuffer3.remove(i)
arrBuffer3.toArray

//9
val arr7 = java.util.TimeZone.getAvailableIDs();
val arr8 = for(i <- arr7) yield {
  if(i.startsWith("America/"))
    i.drop("America/".length)
  else
    i
}
arr8.sorted.foreach(println)

// 10
import java.awt.datatransfer._
import collection.mutable.Buffer
import collection.JavaConversions.asScalaBuffer

val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
val images: Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)
