// Day 7: Collections & Functional Programming
// Learn: Lists, maps, sets, filter/map/reduce operations

fun main() {
    // Lists
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val mutableNumbers = mutableListOf(1, 2, 3)
    mutableNumbers.add(4)
    
    // Functional operations
    val evenNumbers = numbers.filter { it % 2 == 0 }
    val doubled = numbers.map { it * 2 }
    val sum = numbers.reduce { acc, n -> acc + n }
    
    println("Original: $numbers")
    println("Even numbers: $evenNumbers")
    println("Doubled: $doubled")
    println("Sum: $sum")
    
    // Maps
    val ages = mapOf("Alice" to 25, "Bob" to 30, "Charlie" to 35)
    val mutableAges = mutableMapOf("Alice" to 25)
    mutableAges["Bob"] = 30
    
    println("Ages: $ages")
    ages.forEach { (name, age) -> 
        println("$name is $age years old")
    }
    
    // Sets
    val uniqueNumbers = setOf(1, 2, 2, 3, 3, 4)
    println("Unique numbers: $uniqueNumbers")
    
    // Advanced operations
    val words = listOf("kotlin", "android", "development", "fun")
    val longWords = words.filter { it.length > 5 }
    val wordLengths = words.map { it.length }
    val totalLength = words.sumOf { it.length }
    
    println("Words: $words")
    println("Long words: $longWords")
    println("Word lengths: $wordLengths")
    println("Total length: $totalLength")
    
    // TODO: Practice with more collection operations and transformations
}