package com.rlibanez.mrbeam.ui.sections

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rlibanez.mrbeam.client.ApiClient
import com.rlibanez.mrbeam.model.Section
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SectionViewModel : ViewModel() {

    private val _sections = MutableStateFlow<List<Section>>(emptyList())
    val sections: StateFlow<List<Section>> = _sections

    fun fetchSections(contain: String) {
        viewModelScope.launch {
            val response = ApiClient.sectionClient.getSectionsByContainingName(contain)
            if(contain.isEmpty()) {
                _sections.value = emptyList()
            } else if (response.isSuccessful) {
                response.body()?.let {
                    _sections.value = it
                }
            }
        }
    }
}