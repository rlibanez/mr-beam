package com.rlibanez.mrbeam.ui.beam

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rlibanez.mrbeam.R
import com.rlibanez.mrbeam.ui.theme.MrBeamTheme

@Composable
fun BeamActivity(navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .padding(WindowInsets.statusBars.asPaddingValues())
            //horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Configuración de apoyos",
                style = TextStyle(fontSize = 20.sp),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                //verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    //.padding(4.dp)
                    //.padding(WindowInsets.statusBars.asPaddingValues())
            ) {
                Box(modifier = Modifier.offset(x = 2.dp)) {
                    SimpleDropdownMenuExample("izquierda")
                }
                Box(modifier = Modifier.offset(x = (-2).dp)) {
                    SimpleDropdownMenuExample("derecha")
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = {
                    val result = "error"
                    navController.navigate("beamResult/$result")
                },
                modifier = Modifier.padding(48.dp)
            ) {
                Text("Calcular")
            }
        }
    }
}

@Composable
fun SimpleDropdownMenuExample(lado: String) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Cero", "Uno", "Dos", "Tres")
    var images = listOf(
        painterResource(id = R.drawable.support0i),
        painterResource(id = R.drawable.support1i),
        painterResource(id = R.drawable.support2i),
        painterResource(id = R.drawable.support3i))
    if(lado == "derecha") {
        images = listOf(
            painterResource(id = R.drawable.support0d),
            painterResource(id = R.drawable.support1d),
            painterResource(id = R.drawable.support2d),
            painterResource(id = R.drawable.support3d))
    }

    Box {
        Button(
            onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), // Configuración del color de fondo transparente
            contentPadding = PaddingValues(2.dp), // Eliminar el relleno del contenido del botón
            elevation = null, // Desactivar la elevación del botón
            modifier = Modifier.wrapContentSize() // Hacer que el tamaño del botón sea el tamaño del contenido

        ) {
            //Text(text = selectedOption)
            Image(
                painter = images[selectedOptionIndex],
                contentDescription = null,
                modifier = Modifier
                    .size(175.dp)
                    .padding(0.dp)
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEachIndexed { index, _ ->
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                            Image(
                                painter = images[index],
                                contentDescription = null,
                                modifier = Modifier
                                    .size(150.dp)
                                    //.padding(end = 0.dp)
                            )
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
