package com.rlibanez.mrbeam.ui.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.rlibanez.mrbeam.model.Section
import com.rlibanez.mrbeam.model.Units


@Composable
fun SectionsActivity(navController: NavHostController, viewModel: SectionViewModel = viewModel()) {
    val sections = viewModel.sections.collectAsState().value
    var searchText by remember { mutableStateOf("") }

    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(focusRequester) { focusRequester.requestFocus() }

    Surface(modifier = Modifier
        .fillMaxSize()
    )
    {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .padding(WindowInsets.statusBars.asPaddingValues()))
        {
            TextField(
                value = searchText,
                onValueChange = { query ->
                    searchText = query
                    viewModel.fetchSections(query)
                },
                label = { Text("Buscador de secciones") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .focusRequester(focusRequester),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        viewModel.fetchSections(searchText)
                    }
                )
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(sections) { section ->
                    //Text(text = section.name, modifier = Modifier.padding(8.dp))
                    SectionItemTable(section = section)
                }
            }
        }
    }
}

@Composable
fun SectionItemTable(section: Section) {
    val customCardElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,
        pressedElevation = 2.dp,
        focusedElevation = 4.dp
    )
    Card(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = customCardElevation,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            section.name?.let {
                Text(
                    text = "Sección: $it",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    //color = Color(0xFF8e44ad),
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            DataTable(section)
        }
    }
}

@Composable
fun DataTable(section: Section) {
    val data = listOf(
        "G" to section.g,
        "h" to section.h,
        "b" to section.b,
        "tw" to section.tw,
        "tf" to section.tf,
        "r1" to section.r1,
        "r2" to section.r2,
        "A" to section.a,
        "hi" to section.hi,
        "d" to section.d,
        "dmax" to section.dmax,
        "emin" to section.emin,
        "emax" to section.emax,
        "pmin" to section.pmin,
        "pmax" to section.pmax,
        "Al" to section.al,
        "Ag" to section.ag,
        "Iy" to section.iy,
        "Wely" to section.wely,
        "Wply" to section.wply,
        "iy" to section.iyc,
        "Avz" to section.avz,
        "Iz" to section.iz,
        "Welz" to section.welz,
        "Wplz" to section.wplz,
        "iz" to section.izc,
        "ss" to section.ss,
        "It" to section.it,
        "Iw" to section.iw,
        "ys" to section.ys,
        "ym" to section.ym,
        "yS235" to section.yS235,
        "yS355" to section.yS355,
        "yS460" to section.yS460,
        "xS235" to section.xS235,
        "xS355" to section.xS355,
        "xS460" to section.xS460,
        "EN1002522004" to section.en1002522004,
        "EN1002542004" to section.en1002542004,
        "EN102252001" to section.en102252001,
    )
        .filter { it.second != null }

//    Column {
//        data.chunked(3).forEach { rowItems ->
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 4.dp)
//            ) {
//                rowItems.forEach { (label, value) ->
//                    RowItem(label = label, value = value.toString())
//                }
//            }
//        }
//    }

    Column {
        data.forEach { (label, value) ->
            RowItem(label = label, value = value.toString())
        }
    }
}

@Composable
fun RowItem(label: String, value: String) {
    Row(
        modifier = Modifier
            //.weight(1f)
            .padding(end = 4.dp)
            //.background(Color(0xFFF5F5F5), RoundedCornerShape(4.dp))
            .padding(4.dp)
    ) {
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Text(
            text = value,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Units.getUnit(label)?.let {
            Text(
                text = " $it",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SearchScreenPreview() {
    SectionsActivity(navController = rememberNavController())
}