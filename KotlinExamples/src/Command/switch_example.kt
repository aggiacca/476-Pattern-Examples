
package Command

import java.util.ArrayList

/** The Command interface  */
interface Command {
    fun execute()
}

/** The Invoker class  */
class Switch {
    private val history = ArrayList<Command>()

    fun storeAndExecute(cmd: Command) {
        this.history.add(cmd) // optional
        cmd.execute()
    }
}

/** The Receiver class  */
class Light {

    fun turnOn() {
        println("The light is on")
    }

    fun turnOff() {
        println("The light is off")
    }
}

/** The Command for turning on the light - ConcreteCommand #1  */
class FlipUpCommand(private val theLight: Light) : Command {

    override// Command
    fun execute() {
        theLight.turnOn()
    }
}

/** The Command for turning off the light - ConcreteCommand #2  */
class FlipDownCommand(private val theLight: Light) : Command {

    override// Command
    fun execute() {
        theLight.turnOff()
    }
}

/* The test class or client */
object PressSwitch {
    @JvmStatic
    fun main(arguments: Array<String>) {
        // Check number of arguments
        if (arguments.size != 1) {
            System.err.println("Argument \"ON\" or \"OFF\" is required.")
            System.exit(-1)
        }

        val lamp = Light()

        val switchUp = FlipUpCommand(lamp)
        val switchDown = FlipDownCommand(lamp)

        val mySwitch = Switch()

        when (arguments[0]) {
            "ON" -> mySwitch.storeAndExecute(switchUp)
            "OFF" -> mySwitch.storeAndExecute(switchDown)
            else -> {
                System.err.println("Argument \"ON\" or \"OFF\" is required.")
                System.exit(-1)
            }
        }
    }
}