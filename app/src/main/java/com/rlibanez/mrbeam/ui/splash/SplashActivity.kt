package com.rlibanez.mrbeam.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun SplashActivity(navController: NavHostController) {
    Surface(modifier = Modifier
        .fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            //.background(MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "rlibanez\n\nSoftware development",
                //style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                fontSize = 30.sp
            )
        }
    }

    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("principal") {
            popUpTo("splash") { inclusive = true }
        }
    }
}
