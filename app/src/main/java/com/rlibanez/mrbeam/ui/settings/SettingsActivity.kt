package com.rlibanez.mrbeam.ui.settings

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun SettingsActivity(navController: NavHostController) {
    var urlBase by remember { mutableStateOf("") }
    val uriHandler = LocalUriHandler.current

    Surface(modifier = Modifier
        .fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(WindowInsets.statusBars.asPaddingValues())
        ) {
            Text(
                text = "URL base de la API:",
                style = TextStyle(fontSize = 20.sp),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            BasicTextField(
                value = urlBase,
                onValueChange = { urlBase = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .border(1.dp, Color.Gray)
                    .padding(8.dp),
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // Lógica para comprobar la URL base de la API
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(text = "Comprobar")
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Acerca de",
                style = TextStyle(fontSize = 20.sp),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Visita nuestra web",
                style = TextStyle(fontSize = 18.sp, color = Color.Cyan),
                modifier = Modifier.clickable {
                    uriHandler.openUri("https://www.tuweb.com")
                }
            )
        }
    }
}

@Composable
fun MyTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}