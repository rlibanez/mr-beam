package com.rlibanez.mrbeam.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashActivity(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        // Aquí puedes poner una imagen o un logo, o cualquier contenido que desees mostrar en tu splash screen
        Text(
            text = "My App",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
    }

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("principal") {
            popUpTo("splash") { inclusive = true }
        }
    }
}
