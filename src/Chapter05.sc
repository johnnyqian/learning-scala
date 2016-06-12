// 1
class Counter(private var value:Int = 0) {
  def increment = {
    if(value < Int.MaxValue){
      value += 1
    }
  }

  def current = value
}

val c = new Counter(Int.MaxValue - 1)
c.current

c.increment
c.current

c.increment
c.current

// 2
class BankAccount{
  private var balance: Float = 0

  def deposit(value: Float) ={
    balance += value
  }

  def withdraw(value:Float) = {
    if(value > balance){
      throw new Exception("Your balance is not enough for withdraw " + value)
    }
    else {
      balance -= value
    }
  }

  def Balance = balance
}

// 3
class Time(private var hrs:Int = 0, private var min:Int = 0) {
  if(hrs >23 || hrs < 0)
    throw new Exception("Invalid parameter hrs.")

  if(min >59 || hrs < 0)
    throw new Exception("Invalid parameter min.")

  def before(other: Time) :Boolean = {
    hrs < other.hrs || (hrs == other.hrs && min < other.min)
  }
}

try {
  new Time(30, 60)
} catch {
  case e:Exception => println(e.getMessage)
}

new Time(10, 30).before(new Time(11, 0))
new Time(10, 30).before(new Time(9, 0))
new Time(10, 30).before(new Time(10, 30))

// 4
class Time2(private var hrs:Int = 0, private var min:Int = 0) {
  if(hrs >23 || hrs < 0)
    throw new Exception("Invalid parameter hrs.")

  if(min >59 || hrs < 0)
    throw new Exception("Invalid parameter min.")

  private val total = hrs * 60 + min

  def before(other: Time2) :Boolean = {
    total < other.total
  }
}

try {
  new Time2(10, 60)
} catch {
  case e:Exception => println(e.getMessage)
}

new Time2(10, 30).before(new Time2(11, 0))
new Time2(10, 30).before(new Time2(9, 0))
new Time2(10, 30).before(new Time2(10, 30))

// 5
import scala.beans.BeanProperty

class Student(@BeanProperty var name : String, @BeanProperty var id : Long)

//javap -private Student
//Compiled from "Student.scala"
//public class Student {
//  private java.lang.String name;
//  private long id;
//  public java.lang.String name();
//  public void name_$eq(java.lang.String);
//  public void setName(java.lang.String);
//  public long id();
//  public void id_$eq(long);
//  public void setId(long);
//  public java.lang.String getName();
//  public long getId();
//  public Student(java.lang.String, long);
//}

// 6
class Person(private var initialAge:Int) {

  def age = if(initialAge > 0) initialAge else 0

  def age_=(newValue: Int) ={
    if(newValue > initialAge) initialAge = newValue
  }
}

// 7
class Person2(name: String) {
  val firstName = name.split(' ')(0)
  val lastName = name.split(' ')(1)
}
val p = new Person2("Fred Smith")
p.firstName
p.lastName

// 8
class Car(val manufacture: String, val modelName: String) {
  private var modelYear = -1
  var licenceNumber = ""

  def this(manufacture: String, modelName: String, modelYear: Int){
    this(manufacture, modelName)
    this.modelYear = modelYear
  }

  def this(manufacture: String, modelName: String, licenceNumbr: String){
    this(manufacture, modelName)
    this.licenceNumber = licenceNumbr
  }

  def this(manufacture: String, modelName: String, modelYear: Int, licenceNumber: String){
    this(manufacture, modelName, modelYear)
    this.licenceNumber = licenceNumber
  }

  def year = modelYear
}

new Car("Ford", "SUV")
new Car("Ford", "SUV", 1989)
new Car("Ford", "SUV", "JK1234")
new Car("Ford", "SUV", 1989, "JK1234")

// 10
class Employee(val name: String, var salary: Double) {
  def this() { this("John Q. Public", 0.0)}
}

// proposed by Cay Horstmann: http://stackoverflow.com/a/10999828
class Employee2 {
  private var _name = "John Q. Public"
  var salary = 0.0

  def this(name: String, salary: Double){
    this()
    this._name = name
    this.salary = salary
  }

  def name = _name
}