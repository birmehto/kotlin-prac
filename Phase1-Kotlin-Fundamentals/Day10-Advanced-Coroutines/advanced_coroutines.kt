// Day 10: Advanced Coroutines
// Learn: Coroutine scopes, dispatchers, flow basics

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() {
    println("=== Coroutine Scopes ===")
    
    // Custom coroutine scope
    runBlocking {
        val customScope = CoroutineScope(Dispatchers.Default)
        
        customScope.launch {
            println("Running in custom scope")
            delay(1000)
            println("Custom scope task completed")
        }
        
        delay(1500) // Wait for completion
        customScope.cancel() // Clean up
    }
    
    println("\n=== Dispatchers ===")
    
    runBlocking {
        // Default dispatcher (CPU-intensive work)
        launch(Dispatchers.Default) {
            println("Default dispatcher: ${Thread.currentThread().name}")
        }
        
        // IO dispatcher (network/file operations)
        launch(Dispatchers.IO) {
            println("IO dispatcher: ${Thread.currentThread().name}")
        }
        
        // Main dispatcher (UI updates - not available in console)
        launch(Dispatchers.Unconfined) {
            println("Unconfined dispatcher: ${Thread.currentThread().name}")
        }
        
        delay(100)
    }
    
    println("\n=== Flow Basics ===")
    
    // Basic flow
    runBlocking {
        val numberFlow = flow {
            for (i in 1..5) {
                delay(500)
                emit(i)
            }
        }
        
        numberFlow.collect { value ->
            println("Received: $value")
        }
    }
    
    println("\n=== Flow Transformations ===")
    
    runBlocking {
        val dataFlow = (1..10).asFlow()
            .filter { it % 2 == 0 }
            .map { it * it }
            .take(3)
        
        dataFlow.collect { value ->
            println("Transformed value: $value")
        }
    }
    
    println("\n=== Exception Handling ===")
    
    runBlocking {
        try {
            val job = launch {
                throw RuntimeException("Coroutine error")
            }
            job.join()
        } catch (e: Exception) {
            println("Caught exception: ${e.message}")
        }
    }
    
    // TODO: Practice with more advanced coroutine patterns and flow operations
}

// Flow builder function
fun createNumberFlow(): Flow<Int> = flow {
    repeat(5) { i ->
        delay(1000)
        emit(i + 1)
    }
}