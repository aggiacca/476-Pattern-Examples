package Strategy

// Kotlin Hello World Program
fun main(args: Array<String>) {
    val firstCustomer = Customer(NormalBillingStrategy())

    // Normal billing
    firstCustomer.add(1.0, 1)

    // Start Happy Hour
    firstCustomer.setStrategy(HappyBillingStrategy())
    firstCustomer.add(1.0, 2)

    // New Customer
    val secondCustomer = Customer(HappyBillingStrategy())
    secondCustomer.add(0.8, 1)
    // The Customer pays
    firstCustomer.printBill()

    // End Happy Hour
    secondCustomer.setStrategy(NormalBillingStrategy())
    secondCustomer.add(1.3, 2)
    secondCustomer.add(2.5, 1)
    secondCustomer.printBill()
}


interface BillingStrategy{
    fun getActPrice(rawPrice: Double): Double
}

class NormalBillingStrategy : BillingStrategy{
    override fun getActPrice(rawPrice: Double): Double {
        return rawPrice
    }
}

class HappyBillingStrategy : BillingStrategy{
    override fun getActPrice(rawPrice: Double): Double {
        return rawPrice*0.5
    }
}

// any more strategies add here and then add a default none or normal like drink limit strategy
class Customer(private var billStrategy: BillingStrategy, private var drinks: MutableList<Double> = mutableListOf()){

    fun add(price: Double, quantity: Int) {
        drinks.add(billStrategy.getActPrice(price * quantity))
    }

    // Payment of bill
    fun printBill() {
        var sum = 0.0
        for (i in drinks) {
            sum += i
        }
        println("Total due: " + sum)
        drinks.clear()
    }

    // Set Strategy
    fun setStrategy(strategy: BillingStrategy) {
        billStrategy = strategy
    }
}