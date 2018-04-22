package Facade



// Kotlin Hello World Program
fun main(args: Array<String>) {
var cust = Customer("John Bruce", 2500, false, false);
val bk =  Bank()
val  ln =  Loan()
val Credit = Credit()
val Mortgage = MorgageFacade(cust, bk, ln, Credit )
val eligable = Mortgage.IsEligible(cust, 2600)
if (eligable)
System.out.println("Mortgage is approved");
else
System.out.println("Mortgage is not approved");
System.out.println("");

}


class MorgageFacade(val customer: Customer,
                    val bk: Bank,
                    val ln: Loan,
                    val ct: Credit){
    fun IsEligible(cr:Customer, loanAmount: Int): Boolean{
        var eligibleScore = 0
        println(cr.name + " applies for " + loanAmount)
        if (bk.hasSufficientSavings(cr, loanAmount)) {
            eligibleScore += 2
            println("Has sufficient Saving")
        } else {
            eligibleScore -= 1
            println("Doesn't have sufficient Saving")
        }
        if (ct.HasBadCredit(cr)) {
            eligibleScore -= 1
            println("Has Bad Credit")
        } else {
            eligibleScore += 1
            println("credit is good")
        }
        if (ln.HasBadLoan(cr)){
            eligibleScore -= 1
            println("Has bad loan")
        }
        else
        {
        eligibleScore = eligibleScore + 1
        println("No bad loan")
        }
        return eligibleScore >= 2

    }
}


data class Customer( val name: String, val savingAmount: Int, var hasBadLoan: Boolean, var hasBadCredit: Boolean)

class Bank{
    fun hasSufficientSavings(c:Customer, amount: Int): Boolean{
        return c.savingAmount > amount
    }
}

class Loan{
    fun HasBadLoan(C:Customer): Boolean{
        return C.hasBadLoan && C.savingAmount <1000
    }
}

class Credit{
    fun HasBadCredit(C: Customer): Boolean {
        return C.hasBadCredit && C.savingAmount < 1500

    }
}