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

@Composable
fun SplashActivity(navController: NavHostController) {
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
                contentDescription = "Splash Image",
                modifier = Modifier
                    .size(300.dp)
                    //.clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Mr Beam",
                //style = MaterialTheme.typography.bodyLarge,
                //color = Color.White,
                fontSize = 60.sp,
                textAlign = TextAlign.Center
            )
        }
    }

    LaunchedEffect(Unit) {
        delay(4000)
        navController.navigate("principal") {
            popUpTo("splash") { inclusive = true }
        }
    }
}
