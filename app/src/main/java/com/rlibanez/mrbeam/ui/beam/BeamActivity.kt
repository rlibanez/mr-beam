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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
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

    //var config = ""
    var config by remember { mutableStateOf("") }

    var left = ""
    var right = ""
    var load = ""

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        //color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 6.dp, vertical = 16.dp)
                .padding(WindowInsets.statusBars.asPaddingValues())
        ) {
            Text(
                text = "Esquema de carga y sustentación",
                style = TextStyle(fontSize = 20.sp),
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(64.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Box() {
                    load = supportDropdownMenu("cargas")
                }
            }

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(modifier = Modifier
                    .offset(x = 10.dp)) {
                    left = supportDropdownMenu("izquierda")
                }
                Box(modifier = Modifier.offset(x = (-10).dp)) {
                    right = supportDropdownMenu("derecha")
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
                    config = left + right + load
                    navController.navigate("beamResult/$config")
                },
                modifier = Modifier.padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text("Calcular", fontSize = 30.sp)
            }
        }
    }

    config += load
}

@Composable
fun supportDropdownMenu(lado: String): String {
    var expanded by remember { mutableStateOf(false) }
    //val options = listOf("Cero", "Uno", "Dos", "Tres")
    var size by remember { mutableStateOf(190.dp) }
    var paddingValues = PaddingValues(start = 10.dp, top = 0.dp, end = 0.dp, bottom = 10.dp)

    var result = ""

    var initialIndex = 2

    var images = listOf(
    painterResource(id = R.drawable.support0i),
    painterResource(id = R.drawable.support1i),
    painterResource(id = R.drawable.support2i),
    painterResource(id = R.drawable.support3i)
    )

    when(lado) {
        "derecha" -> {
            images = listOf(
                painterResource(id = R.drawable.support0d),
                painterResource(id = R.drawable.support1d),
                painterResource(id = R.drawable.support2d),
                painterResource(id = R.drawable.support3d)
            )
            paddingValues = PaddingValues(start = 0.dp, top = 0.dp, end = 10.dp, bottom = 10.dp)
            initialIndex = 1
        }
        "cargas" -> {
            images = listOf(
                painterResource(id = R.drawable.f1a),
                painterResource(id = R.drawable.qa),
                painterResource(id = R.drawable.ql),
                painterResource(id = R.drawable.qca)
            )
            size = 350.dp
            paddingValues = PaddingValues(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 5.dp)
            initialIndex = 0
        }
    }


    var selectedOptionIndex by remember { mutableIntStateOf(initialIndex) }

    Box {
        Button(
            onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(0.dp),
            elevation = null,
            modifier = Modifier.wrapContentSize()
        ) {
            Image(
                painter = images[selectedOptionIndex],
                contentDescription = null,
                modifier = Modifier
                    .width(size)
                    .padding(paddingValues)
            )
        }
        DropdownMenu(
            expanded = expanded,
            modifier = Modifier
                .width(size + 20.dp),
            onDismissRequest = { expanded = false }
        ) {
            images.forEachIndexed { index, _ ->
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                            Image(
                                painter = images[index],
                                contentDescription = null,
                                modifier = Modifier
                                    .width(size)
                                    .padding(horizontal = 10.dp, vertical = 10.dp)
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

    return selectedOptionIndex.toString()
}



@Preview(showBackground = true)
@Composable
fun BeamActivityPreview() {
    MrBeamTheme {
        BeamActivity(navController = rememberNavController())
    }
}
