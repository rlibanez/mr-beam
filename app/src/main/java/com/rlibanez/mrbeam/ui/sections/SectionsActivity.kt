package com.rlibanez.mrbeam.ui.sections

import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SectionsActivity(navController: NavHostController, viewModel: SectionViewModel = viewModel()) {
    val sections = viewModel.sections.collectAsState().value
    var searchText by remember { mutableStateOf("") }

    Surface(modifier = Modifier
        .fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .padding(WindowInsets.statusBars.asPaddingValues())) {

            TextField(
                value = searchText,
                onValueChange = { query ->
                    searchText = query
                    viewModel.fetchSections(query)
                },
                label = { Text("Buscar") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(sections) { section ->
                    //Text(text = section.name, modifier = Modifier.padding(8.dp))
                    SectionItem(section = section)
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun SearchScreenPreview() {
    SectionsActivity(navController = rememberNavController())
}