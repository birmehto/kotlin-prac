// Day 6: Data Classes & Sealed Classes
// Learn: Data class benefits, sealed class hierarchies, enum classes

fun main() {
    // Data classes
    val user1 = User("John", "john@email.com", 25)
    val user2 = User("John", "john@email.com", 25)
    
    println("User1: $user1")
    println("Users equal: ${user1 == user2}")
    
    val updatedUser = user1.copy(age = 26)
    println("Updated user: $updatedUser")
    
    // Sealed classes
    val results = listOf(
        ApiResult.Success("Data loaded successfully"),
        ApiResult.Error("Network error", 404),
        ApiResult.Loading
    )
    
    results.forEach { result ->
        handleApiResult(result)
    }
    
    // Enum classes
    val priority = Priority.HIGH
    println("Task priority: $priority (${priority.level})")
    
    // TODO: Create more data classes and sealed class hierarchies
}

// Data class
data class User(val name: String, val email: String, val age: Int)

// Sealed class
sealed class ApiResult {
    data class Success(val message: String) : ApiResult()
    data class Error(val message: String, val code: Int) : ApiResult()
    object Loading : ApiResult()
}

// Enum class
enum class Priority(val level: Int) {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    URGENT(4)
}

fun handleApiResult(result: ApiResult) {
    when (result) {
        is ApiResult.Success -> println("✅ ${result.message}")
        is ApiResult.Error -> println("❌ Error ${result.code}: ${result.message}")
        is ApiResult.Loading -> println("⏳ Loading...")
    }
}