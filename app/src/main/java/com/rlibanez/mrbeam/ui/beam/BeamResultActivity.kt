package com.rlibanez.mrbeam.ui.beam

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun BeamResultScreen(navController: NavHostController, result: String) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                val texto = if (result == "error") "Fatal error" else result
                Text(text = texto)
            }

    }
}