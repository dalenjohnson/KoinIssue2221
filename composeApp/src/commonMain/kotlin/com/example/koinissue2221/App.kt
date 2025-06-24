package com.example.koinissue2221

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App(
    platformModule: Module = Module()
) {
    val navController = rememberNavController()

    KoinApplication(
        application = {
            modules(
                platformModule,
                viewModelModule
            )
        }
    ) {
        MaterialTheme {
            NavHost(
                navController = navController,
                startDestination = "first_screen"
            ) {
                composable("first_screen") {
                    FirstScreen(navController = navController)
                }
                composable("second_screen") {
                    SecondScreen(navController = navController)
                }
            }
        }
    }
}

val viewModelModule = module {

    viewModelOf(::SecondScreenViewModel)
}

class SecondScreenViewModel(): ViewModel() {
    val content = "ViewModel Content"
}

@Composable
fun FirstScreen(navController: NavHostController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(all = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "First Screen",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 32.dp),
                color = MaterialTheme.colorScheme.onBackground
            )

            Button(
                onClick = { navController.navigate("second_screen") },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Go to Second Screen")
            }
            Text(
                text = "To cause the app to crash tigger a configuration change by rotating the device or toggling the system dark mode and then navigate to the second screen.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(vertical = 16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    navController: NavHostController,
    viewModel: SecondScreenViewModel = koinInject()
) {

    Scaffold{ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Second Screen!",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = viewModel.content,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding( vertical = 16.dp),
                color = MaterialTheme.colorScheme.onBackground
            )
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Back")
            }

        }
    }
}