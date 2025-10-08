// Day 21: Compose Setup & Mental Model
// Learn: Declarative vs imperative UI, composable functions, preview system

package com.example.composebasics

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ComposeBasicsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Simple text composable
        Text(
            text = "Welcome to Jetpack Compose!",
            style = MaterialTheme.typography.headlineMedium
        )
        
        // Button with state
        var clickCount by remember { mutableStateOf(0) }
        
        Button(
            onClick = { clickCount++ }
        ) {
            Text("Clicked $clickCount times")
        }
        
        // Conditional UI
        if (clickCount > 5) {
            Text(
                text = "You're getting the hang of it!",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
        
        // Custom composable
        GreetingCard(name = "Compose Developer")
    }
}

@Composable
fun GreetingCard(name: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Hello, $name!",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "This is your first Compose component",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeBasicsPreview() {
    MaterialTheme {
        ComposeBasicsScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingCardPreview() {
    MaterialTheme {
        GreetingCard(name = "Preview User")
    }
}

// TODO: Practice with more composable functions and preview variations