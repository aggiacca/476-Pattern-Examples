package Command

import java.io.Console



fun main(args: Array<String>) {
    val Receiver_Cook = Receiver_Cook()
    val command_order = ConcreteCommand_order(Receiver_Cook)
    val invoker_Waitress = invoker_Waitress()
    // Set and execute command_order
    invoker_Waitress.SetCommand_TakeOrder(command_order)
    invoker_Waitress.Orderup()
}

abstract class Command_order {
    protected var Receiver_Cook: Receiver_Cook? = null
    abstract fun Execute_Orderup()
}

class ConcreteCommand_order(receiver_Cook: Receiver_Cook) : Command_order()
{
    init{
        Receiver_Cook = receiver_Cook
    }
    override fun Execute_Orderup()
    {
        Receiver_Cook?.MakeBurger()
        Receiver_Cook?.MakeShake()
    }
}

internal class invoker_Waitress {
    private var command_order: Command_order? = null
    fun SetCommand_TakeOrder(command_order: Command_order) {
        this.command_order = command_order
    }

    fun Orderup() {
        command_order!!.Execute_Orderup()
    }
}


class Receiver_Cook {
    fun MakeBurger() {
        println("Make a Cheese Burger")
    }

    fun MakeShake() {
        println("Make a Malt Shake")
    }
}