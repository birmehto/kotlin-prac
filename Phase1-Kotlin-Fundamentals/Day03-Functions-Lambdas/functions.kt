// Day 3: Functions & Lambdas
// Learn: Function syntax, higher-order functions, lambda expressions

fun main() {
    // Basic functions
    println(greet("Kotlin Developer"))
    println("Sum: ${add(5, 3)}")
    
    // Higher-order functions
    val numbers = listOf(1, 2, 3, 4, 5)
    val doubled = numbers.map { it * 2 }
    println("Doubled: $doubled")
    
    // Lambda expressions
    val multiply = { a: Int, b: Int -> a * b }
    println("Multiply: ${multiply(4, 5)}")
    
    // Function as parameter
    calculate(10, 5) { a, b -> a + b }
    calculate(10, 5) { a, b -> a - b }
    
    // TODO: Create more functions and practice with lambdas
}

fun greet(name: String): String {
    return "Hello, $name!"
}

fun add(a: Int, b: Int) = a + b

fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int) {
    val result = operation(a, b)
    println("Result: $result")
}