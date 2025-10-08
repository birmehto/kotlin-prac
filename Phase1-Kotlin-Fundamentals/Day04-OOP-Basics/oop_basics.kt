// Day 4: Object-Oriented Programming Basics
// Learn: Classes, constructors, properties, methods

fun main() {
    val person = Person("Alice", 30)
    person.introduce()
    person.celebrateBirthday()
    
    val car = Car("Toyota", "Camry", 2023)
    car.displayInfo()
    car.start()
    
    // TODO: Create more classes and practice with different constructors
}

class Person(val name: String, var age: Int) {
    
    fun introduce() {
        println("Hi, I'm $name and I'm $age years old")
    }
    
    fun celebrateBirthday() {
        age++
        println("Happy birthday! Now I'm $age years old")
    }
}

class Car(val make: String, val model: String, val year: Int) {
    private var isRunning = false
    
    fun start() {
        isRunning = true
        println("$make $model is now running")
    }
    
    fun stop() {
        isRunning = false
        println("$make $model has stopped")
    }
    
    fun displayInfo() {
        println("Car: $year $make $model")
    }
}