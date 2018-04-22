package Adapter

// Kotlin Hello World Program
fun main(args: Array<String>) {
    val benezene: Compound = RichCompound("benzene")
    benezene.Display()
}


/// <summary>

/// The 'Target' class

/// </summary>

open class Compound(val chemical: String,
                    var boilingPoint: Float = 0.0F,
                    val meltingPoint: String = "",
                    val molecularWeight: String ="",
                    val molecularFormula: String =""){

    open public fun Display(){
        System.out.println("Compound: $chemical ------ ")
    }
}

/// <summary>

/// The 'Adapter' class

/// </summary>

class RichCompound(_name: String) : Compound(_name){
    val oldData = ChemicalData()

    override fun Display() {
        super.Display()
        boilingPoint = oldData.GetCriticalPoint("benzene")
        System.out.println("Boiling Pt: $boilingPoint")
    }

}

/// <summary>

/// The 'Adaptee' class

/// </summary>

class ChemicalData(){
    // The databank 'legacy API'

    public fun GetCriticalPoint(type: String) : Float{
        return when(type){
            "water" -> 0.0F
            "benzene" -> 5.5F
            else -> 0.0F
        }
    }
}