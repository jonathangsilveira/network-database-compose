package edu.jgsilveira.networkdatabase.compose.features.checklist.list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ChecklistsViewModel : ViewModel() {
    private val internalState = MutableStateFlow<ChecklistsUIState>(
        ChecklistsUIState.Initial
    )
    val state: StateFlow<ChecklistsUIState> = internalState

    fun getAllChecklists() = Unit
}