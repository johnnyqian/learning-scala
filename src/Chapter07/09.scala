package chapter07 {

  object Test09 extends App {

    import scala.io.StdIn._
    import java.lang.System._
    import java.lang.System.err.{println => printerr}

    val username = getProperty("user.name")
    val password = readLine("please input password:")

    if (password == "secret")
      println("Welcome.")
    else
      printerr("Invalid password.")
  }

}
