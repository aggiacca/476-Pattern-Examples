package Observer

// Kotlin Hello World Program
fun main(args: Array<String>) {
    val weatherData = WeatherData(80, 65, 30.4f)
    val Forecast = ForecastDisplay()
    weatherData.registerObserver(Forecast)
    weatherData.setMeasurements(82, 70, 29.2f)
    weatherData.setMeasurements(78, 90, 30.2f)
}

interface Subject {
    fun registerObserver(o: Observer)
    fun removeObserver(o: Observer)
    fun notifyObservers()
}

interface Observer {
    fun update(temp: Int, humidity: Int, pressure: Float)
}

interface DisplayElement {
    fun display()
}

class WeatherData(
        private var temperature: Int,
        private var humidity: Int,
        private var pressure: Float,
        private var observers: ArrayList<Observer> = arrayListOf()
) : Subject {
    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        val i = observers.indexOf(o)
        if (i >= 0) {
            observers.removeAt(i)
        }
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(temperature, humidity, pressure)
        }
    }

    fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temperature: Int, humidity: Int, pressure: Float){
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}

class ForecastDisplay(
        private var currentPressure: Float? = null,
        private var lastPressure: Float? = null
) : Observer, DisplayElement {


    override fun display() {
        println("Pressure: $currentPressure")
    }

    override fun update(temp: Int, humidity: Int, pressure: Float) {
        lastPressure = currentPressure
        currentPressure = pressure
        display()
    }
}