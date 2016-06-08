// 1
def signum(x: Int) : Int = {
  if(x>0) 1
  else if(x==0) 0
  else -1
}

signum(10)
signum(0)
signum(-2)

// 3
var x:Unit = ()
var y:Int = 0
x = y = 1
x
y

// 4
for(i <- 0 to 10 reverse) printf("%2d",i)

// 6
var r:Long = 1
for(c<-"Hello") r*=c
r

// 7
"Hello".map(_.toLong).product

// 8
def product(str: String):BigInt = {
  str.map(BigInt(_)).product
}
product("Hello")

// 9
def productRecursive(str: String):BigInt = {
  if(str.length == 1)
    BigInt(str.head)
  else
    BigInt(str.head) * productRecursive(str.tail)
}
productRecursive("Hello")
