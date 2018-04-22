package Template

// Kotlin Hello World Program
fun main(args: Array<String>) {
    val tea: CaffeineBeverage = Tea()
    val coffee: CaffeineBeverage = Coffee()
    println("\nMaking tea...")
    tea.prepareRecipe()
    println("\nMaking coffee...")
    coffee.prepareRecipe()
}

//CaffeineBeverage is abstract, just like in the class design
abstract class CaffeineBeverage {
     fun prepareRecipe() {
        boilWater()
        brew()
        pourInCup()
        addCondimentsHook()
    }


    //Class specific
     abstract fun brew()
    abstract fun addCondiments()
    open fun addCondimentsHook(){
        println("add condiments Y/N?: ")
        val answer = readLine().toString()
        if (answer == "Y"){
            addCondiments()
        }else{

        }
     }

    // Parts that all caffeineCeverages use (template method)
     fun boilWater() {
        println("Boiling water")
    }

     fun pourInCup() {
        println("Pouring into cup")
    }
}

class Coffee : CaffeineBeverage() {
    override fun brew() {
        println("Dripping Coffee through filter")
    }

    override fun addCondiments() {
        println("Adding Sugar and Milk")
    }
}

class Tea : CaffeineBeverage() {
    override fun brew() {
        println("Steeping the tea")
    }

    override fun addCondiments() {
        println("Adding Lemon")
    }
}