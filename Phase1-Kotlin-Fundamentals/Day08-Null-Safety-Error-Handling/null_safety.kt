// Day 8: Null Safety & Error Handling
// Learn: Nullable types, safe calls, Elvis operator, try/catch

fun main() {
    // Nullable types
    var name: String? = "Kotlin"
    var nullableName: String? = null
    
    // Safe calls
    println("Name length: ${name?.length}")
    println("Nullable name length: ${nullableName?.length}")
    
    // Elvis operator
    val displayName = nullableName ?: "Unknown"
    println("Display name: $displayName")
    
    // Let function with null safety
    name?.let { 
        println("Name is not null: $it")
    }
    
    nullableName?.let {
        println("This won't print")
    } ?: println("Nullable name is null")
    
    // Error handling with try/catch
    val numbers = listOf("1", "2", "abc", "4")
    
    numbers.forEach { numberString ->
        try {
            val number = numberString.toInt()
            println("Parsed number: $number")
        } catch (e: NumberFormatException) {
            println("Failed to parse '$numberString': ${e.message}")
        }
    }
    
    // Safe parsing with runCatching
    val safeResults = numbers.map { 
        runCatching { it.toInt() }
            .getOrNull()
    }
    println("Safe parsing results: $safeResults")
    
    // Custom error handling
    val result = divideNumbers(10, 0)
    when (result) {
        is Result.Success -> println("Division result: ${result.value}")
        is Result.Error -> println("Division error: ${result.message}")
    }
    
    // TODO: Practice with more null safety patterns and error handling
}

sealed class Result<T> {
    data class Success<T>(val value: T) : Result<T>()
    data class Error<T>(val message: String) : Result<T>()
}

fun divideNumbers(a: Int, b: Int): Result<Double> {
    return if (b != 0) {
        Result.Success(a.toDouble() / b)
    } else {
        Result.Error("Division by zero is not allowed")
    }
}