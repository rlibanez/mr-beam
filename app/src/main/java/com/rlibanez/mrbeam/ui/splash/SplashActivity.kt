package com.rlibanez.mrbeam.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.rlibanez.mrbeam.R
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SplashActivity(navController: NavHostController) {
    SplashScreen()

    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("principal") {
            popUpTo("splash") { inclusive = true }
        }
    }
}

@Composable
fun SplashScreen() {
    Surface(modifier = Modifier
        .fillMaxSize(),
        color = Color(0xFFF3F1E5)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            //.background(MaterialTheme.colorScheme.primary),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash),
                contentDescription = "Mr Beam",
                modifier = Modifier
                    .size(288.dp)
                //.clip(CircleShape)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashActivityPreview() {
    SplashScreen()
}