package com.rlibanez.mrbeam.ui.beam

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rlibanez.mrbeam.R

@Composable
fun BeamResultScreen(navController: NavHostController, result: String) {
    val scrollState = rememberScrollState()


    val title = mapOf(
        "210" to "Viga simple apoyada: carga puntual genérica",
        "211" to "Viga simple apoyada: carga uniforme en un extremo",
        "212" to "Viga simple apoyada: carga uniforme en todo el vano",
        "213" to "Viga simple apoyada: carga uniforme en tramo intermedio"
    )

    val imageResource = when (result) {
        "210" -> R.drawable._210
        "211" -> R.drawable._211
        "212" -> R.drawable._212
        "213" -> R.drawable._213
        else -> R.drawable.ic_launcher_foreground
    }

    val texto = title.getOrDefault(result, "No se encontró la combinación")

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(WindowInsets.statusBars.asPaddingValues())
        ) {
            Text(
                text = texto,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = "Viga",
                    modifier = Modifier
                        .fillMaxWidth()
                    //.height(200.dp),
                    //contentScale = ContentScale.Crop
                )
            }
//            Spacer(modifier = Modifier.height(16.dp))
//            Image(
//                painter = painterResource(id = R.drawable.image2),
//                contentDescription = "Imagen 2",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp),
//                contentScale = ContentScale.Crop
//            )
        }

    }
}