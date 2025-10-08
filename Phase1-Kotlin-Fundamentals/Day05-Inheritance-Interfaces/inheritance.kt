// Day 5: Inheritance & Interfaces
// Learn: Class inheritance, abstract classes, interface implementation

fun main() {
    val dog = Dog("Buddy", "Golden Retriever")
    dog.makeSound()
    dog.fetch()
    
    val cat = Cat("Whiskers", "Persian")
    cat.makeSound()
    cat.climb()
    
    val shapes = listOf(
        Circle(5.0),
        Rectangle(4.0, 6.0)
    )
    
    shapes.forEach { shape ->
        println("Area: ${shape.calculateArea()}")
        shape.draw()
    }
    
    // TODO: Create more inheritance hierarchies and interfaces
}

// Abstract class
abstract class Animal(val name: String) {
    abstract fun makeSound()
    
    fun sleep() {
        println("$name is sleeping")
    }
}

// Interface
interface Drawable {
    fun draw()
}

// Inheritance
class Dog(name: String, val breed: String) : Animal(name) {
    override fun makeSound() {
        println("$name barks: Woof!")
    }
    
    fun fetch() {
        println("$name is fetching the ball")
    }
}

class Cat(name: String, val breed: String) : Animal(name) {
    override fun makeSound() {
        println("$name meows: Meow!")
    }
    
    fun climb() {
        println("$name is climbing a tree")
    }
}

// Abstract class with interface
abstract class Shape : Drawable {
    abstract fun calculateArea(): Double
}

class Circle(private val radius: Double) : Shape() {
    override fun calculateArea() = Math.PI * radius * radius
    
    override fun draw() {
        println("Drawing a circle with radius $radius")
    }
}

class Rectangle(private val width: Double, private val height: Double) : Shape() {
    override fun calculateArea() = width * height
    
    override fun draw() {
        println("Drawing a rectangle ${width}x${height}")
    }
}