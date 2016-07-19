package chapter08 {
  class BankAccount(initialBalance: Double){
    private var balance = initialBalance

    def deposit(amount: Double) = {
      balance += amount
      balance
    }

    def withdraw(amount: Double) = {
      balance -= amount
      balance
    }

    override def toString = "Balance = %f".format(balance)
  }

  class CheckingAccount(initialBalance: Double, val commission: Double = 1.0) extends BankAccount(initialBalance) {
    override def deposit(amount: Double) = super.deposit(amount - commission)
    override def withdraw(amount: Double) = super.withdraw(amount + commission)
  }

  object Test01 extends App {
    val acc = new CheckingAccount(100)

    acc.deposit(100)
    println(acc)

    acc.withdraw(100)
    println(acc)
  }
}
