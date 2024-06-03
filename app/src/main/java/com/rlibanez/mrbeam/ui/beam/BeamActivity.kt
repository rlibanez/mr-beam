package com.rlibanez.mrbeam.ui.beam

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rlibanez.mrbeam.ui.theme.MrBeamTheme

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.rlibanez.mrbeam.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeamActivity(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(WindowInsets.statusBars.asPaddingValues())
        ) {
            Text(text = "Ejemplo de DropdownMenu", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            SimpleDropdownMenuExample()
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Ejemplo de ExposedDropdownMenuBox",
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun SimpleDropdownMenuExample() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Selecciona una opción") }
    var selectedOptionIndex by remember { mutableStateOf(0) }
    val options = listOf("Opción 1", "Opción 2", "Opción 3")
    val images = listOf(
        painterResource(id = R.drawable.cero),
        painterResource(id = R.drawable.uno),
        painterResource(id = R.drawable.dos),
        painterResource(id = R.drawable.tres))

    Box {
        Button(
            onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), // Configuración del color de fondo transparente
            contentPadding = PaddingValues(0.dp), // Eliminar el relleno del contenido del botón
            elevation = null, // Desactivar la elevación del botón
            modifier = Modifier.wrapContentSize() // Hacer que el tamaño del botón sea el tamaño del contenido

        ) {
            //Text(text = selectedOption)
            Image(
                painter = images[selectedOptionIndex],
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .padding(end = 6.dp)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEachIndexed { index, option ->
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                            Image(
                                painter = images[index],
                                contentDescription = null,
                                modifier = Modifier
                                    .size(150.dp)
                                    .padding(end = 6.dp)
                            )
                            //Text(option)
                        }
                    },
                    onClick = {
                        selectedOptionIndex = index
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BeamActivityPreview() {
    MrBeamTheme {
        BeamActivity(navController = rememberNavController())
    }
}
