/**
  * Created by Johnny Qian on 11/23/16.
  */

package chapter09 {

  import java.io.PrintWriter

  object Test05 extends App {
    val out = new PrintWriter("src/Chapter09/05.out")

    for(n <- 0 to 20){
      val k = BigDecimal(2).pow(n)

      out.println("%8s %s".format(k, 1/k))
    }

    out.close()
  }
}

