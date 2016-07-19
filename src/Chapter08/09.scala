package chapter08 {
  class Creature {
    def range: Int = 10
    val env: Array[Int] = new Array[Int](range)
  }

  class Ant1 extends Creature {
    override def range = 2
  }

  class Ant2 extends Creature {
    override val range = 2
  }

  object Test09 extends App {
    val a1 = new Ant1()
    println(a1.env.length) // 2

    val a2 = new Ant2()
    println(a2.env.length) // 0
  }
}

/*
回答: http://www.cnblogs.com/sunddenly/p/4441491.html
def覆写def，子类的env可以正确初始化。而用val覆写def，env会被初始化成0长度。这个跟val覆写val的道理是一样的。
父类和子类同时存在私有的同名变量range和相同的range的getter，但是父类的构造函数先被调用，却要在其中调用子类的getter，
因为父类的getter被子类覆写。子类的range因为此时还没初始化，所以返回了0。父类构造函数，错误地使用0来初始化了env。
这种行为本身就是个坑，但是也提供了非常大的灵活性。面向对象的Template设计模式就依赖这种行为实现的，所以还是多多善用为妙。
 */