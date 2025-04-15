package edu.jgsilveira.networkdatabase.compose.features.checklist.list

sealed interface ChecklistsUIState {
    data object Initial : ChecklistsUIState
    data object Loading : ChecklistsUIState
    data class Success(
        val checklists: List<Checklist>
    ) : ChecklistsUIState
    data object Error : ChecklistsUIState
}