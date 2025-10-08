// Milestone Project: Console To-Do App
// Build: Command-line app with CRUD operations using coroutines for async file I/O

import kotlinx.coroutines.*
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean = false,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    override fun toString(): String {
        val status = if (isCompleted) "✅" else "❌"
        val dateStr = createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
        return "$status [$id] $title - $description (Created: $dateStr)"
    }
}

class TodoManager {
    private val tasks = mutableListOf<Task>()
    private var nextId = 1
    private val fileName = "tasks.txt"
    
    suspend fun loadTasks() {
        withContext(Dispatchers.IO) {
            val file = File(fileName)
            if (file.exists()) {
                // Simple file loading - in real app, use proper serialization
                println("Loading tasks from file...")
                delay(500) // Simulate file I/O
            }
        }
    }
    
    suspend fun saveTasks() {
        withContext(Dispatchers.IO) {
            println("Saving tasks to file...")
            delay(300) // Simulate file I/O
            // In real implementation, save tasks to file
        }
    }
    
    suspend fun addTask(title: String, description: String) {
        val task = Task(nextId++, title, description)
        tasks.add(task)
        println("✅ Task added: ${task.title}")
        saveTasks()
    }
    
    fun listTasks() {
        if (tasks.isEmpty()) {
            println("No tasks found.")
            return
        }
        
        println("\n=== Your Tasks ===")
        tasks.forEach { task ->
            println(task)
        }
        println()
    }
    
    suspend fun completeTask(id: Int) {
        val taskIndex = tasks.indexOfFirst { it.id == id }
        if (taskIndex != -1) {
            tasks[taskIndex] = tasks[taskIndex].copy(isCompleted = true)
            println("✅ Task $id marked as completed!")
            saveTasks()
        } else {
            println("❌ Task with ID $id not found.")
        }
    }
    
    suspend fun deleteTask(id: Int) {
        val removed = tasks.removeIf { it.id == id }
        if (removed) {
            println("🗑️ Task $id deleted!")
            saveTasks()
        } else {
            println("❌ Task with ID $id not found.")
        }
    }
}

suspend fun main() {
    val todoManager = TodoManager()
    
    println("🚀 Welcome to Kotlin Todo App!")
    println("Loading your tasks...")
    
    todoManager.loadTasks()
    
    while (true) {
        println("\n=== Todo App Menu ===")
        println("1. Add Task")
        println("2. List Tasks")
        println("3. Complete Task")
        println("4. Delete Task")
        println("5. Exit")
        print("Choose an option: ")
        
        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Enter task title: ")
                val title = readLine() ?: ""
                print("Enter task description: ")
                val description = readLine() ?: ""
                
                if (title.isNotBlank()) {
                    todoManager.addTask(title, description)
                } else {
                    println("❌ Title cannot be empty!")
                }
            }
            
            2 -> todoManager.listTasks()
            
            3 -> {
                print("Enter task ID to complete: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    todoManager.completeTask(id)
                } else {
                    println("❌ Invalid ID!")
                }
            }
            
            4 -> {
                print("Enter task ID to delete: ")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    todoManager.deleteTask(id)
                } else {
                    println("❌ Invalid ID!")
                }
            }
            
            5 -> {
                println("👋 Thanks for using Todo App!")
                break
            }
            
            else -> println("❌ Invalid option! Please try again.")
        }
    }
}

// TODO: Enhance with file persistence, categories, due dates, and search functionality