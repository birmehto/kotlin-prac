// Day 9: Coroutines Introduction
// Learn: Async programming concepts, launch, async/await

import kotlinx.coroutines.*

fun main() {
    println("=== Basic Coroutines ===")
    
    // Basic coroutine launch
    runBlocking {
        launch {
            delay(1000)
            println("Coroutine completed after 1 second")
        }
        
        println("Main thread continues...")
        delay(1500) // Wait for coroutine to complete
    }
    
    println("\n=== Multiple Coroutines ===")
    
    // Multiple coroutines
    runBlocking {
        repeat(3) { i ->
            launch {
                delay((i + 1) * 500L)
                println("Coroutine $i completed")
            }
        }
        
        delay(2000) // Wait for all coroutines
    }
    
    println("\n=== Async/Await ===")
    
    // Async/await for concurrent execution
    runBlocking {
        val deferred1 = async { fetchData("API 1", 1000) }
        val deferred2 = async { fetchData("API 2", 1500) }
        
        val result1 = deferred1.await()
        val result2 = deferred2.await()
        
        println("Results: $result1, $result2")
    }
    
    println("\n=== Sequential vs Concurrent ===")
    
    // Sequential execution
    runBlocking {
        val time = measureTimeMillis {
            val result1 = fetchData("Sequential 1", 1000)
            val result2 = fetchData("Sequential 2", 1000)
            println("Sequential results: $result1, $result2")
        }
        println("Sequential time: ${time}ms")
    }
    
    // Concurrent execution
    runBlocking {
        val time = measureTimeMillis {
            val result1 = async { fetchData("Concurrent 1", 1000) }
            val result2 = async { fetchData("Concurrent 2", 1000) }
            println("Concurrent results: ${result1.await()}, ${result2.await()}")
        }
        println("Concurrent time: ${time}ms")
    }
    
    // TODO: Practice with more coroutine patterns and error handling
}

suspend fun fetchData(source: String, delayMs: Long): String {
    delay(delayMs)
    return "Data from $source"
}