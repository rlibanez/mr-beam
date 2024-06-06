package com.rlibanez.mrbeam.ui.principal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PrincipalActivity(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Mr Beam",
            style = TextStyle(fontSize = 80.sp),
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(64.dp))
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate("beam") }) {
            Text(text = "Vigas", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate("sections") }) {
            Text(text = "Secciones", fontSize = 30.sp)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = { navController.navigate("settings") }) {
            Text(text = "Ajustes", fontSize = 30.sp)
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun MainScreenPreview() {
    PrincipalActivity(navController = rememberNavController())
}