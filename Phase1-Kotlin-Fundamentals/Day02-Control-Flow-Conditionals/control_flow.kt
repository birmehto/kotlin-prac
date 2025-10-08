// Day 2: Control Flow & Conditionals
// Learn: if/when expressions, loops, ranges

fun main() {
    // If expressions
    val score = 85
    val grade = if (score >= 90) "A" else if (score >= 80) "B" else "C"
    println("Grade: $grade")
    
    // When expressions
    val dayOfWeek = 3
    val dayName = when (dayOfWeek) {
        1 -> "Monday"
        2 -> "Tuesday"
        3 -> "Wednesday"
        4 -> "Thursday"
        5 -> "Friday"
        else -> "Weekend"
    }
    println("Today is $dayName")
    
    // Loops and ranges
    println("Counting 1 to 5:")
    for (i in 1..5) {
        println(i)
    }
    
    println("Even numbers from 2 to 10:")
    for (i in 2..10 step 2) {
        println(i)
    }
    
    // TODO: Practice with different conditional patterns and loops
}