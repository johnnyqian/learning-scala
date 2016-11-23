/**
  * Created by Johnny Qian on 11/24/16.
  */

package chapter09

import java.io.File

object Test09 extends App{

  def subdirs(dir: File): Iterator[File] = {
    val allClassFiles = dir.listFiles.filter(_.getName.endsWith(".class"))
    allClassFiles.toIterator ++ dir.listFiles.filter(_.isDirectory).toIterator.flatMap(subdirs _)
  }

  val workingDirectory = new File(".")
  println(workingDirectory.getCanonicalPath)
  println(subdirs(workingDirectory).length)
}
