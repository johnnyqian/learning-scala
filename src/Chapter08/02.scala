package chapter08 {
  class SavingAccount(initialBalance: Double,
                      val commission: Double = 1.0,
                      val interestRateMonthly: Double = 0.01,
                      val freeTransactionTimes: Int = 3) extends BankAccount(initialBalance) {
    var transactionTimes : Int = 0

    def earnMonthlyInterest = {
      transactionTimes = 0
      super.deposit(super.deposit(0) * interestRateMonthly)
    }

    override def deposit(amount: Double) = {
      transactionTimes += 1
      if (transactionTimes <= freeTransactionTimes)
        super.deposit(amount)
      else
        super.deposit(amount - commission)
    }

    override def withdraw(amount: Double) = {
      transactionTimes += 1
      if (transactionTimes <= freeTransactionTimes)
        super.withdraw(amount)
      else
        super.withdraw(amount + commission)
    }
  }

  object Test02 extends App {
    val acc = new SavingAccount(100)

    acc.deposit(100)
    println(acc)

    acc.withdraw(100)
    println(acc)

    acc.deposit(100)
    println(acc)

    acc.withdraw(100)
    println(acc)

    acc.earnMonthlyInterest
    println(acc)
  }
}
