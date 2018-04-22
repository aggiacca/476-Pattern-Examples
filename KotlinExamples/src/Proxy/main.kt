package Proxy

// Kotlin Hello World Program
fun main(args: Array<String>) {
    val proxy = ProtectionProxy()
    val output = proxy.getAccountNo()
    println("Output $output")
}

interface IClient{
    fun getAccountNo(): String
}

class RealClient(private val accountNumber: Int, val password: String): IClient{
    override fun getAccountNo(): String {
        return accountNumber.toString()
    }
}

class ProtectionProxy(val password: String = ""): IClient{
    var realC: RealClient = RealClient(12345, "hunter2")

    override fun getAccountNo(): String {
        println("Password: ")
        val pass = readLine().toString()

        return if(pass == realC.password){
             realC.getAccountNo()
        }else{
            println("Illegal password")
             ""
        }
    }
}