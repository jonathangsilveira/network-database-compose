package edu.jgsilveira.networkdatabase.compose.features.checklist.edit

import network_database_compose.composeapp.generated.resources.Res
import network_database_compose.composeapp.generated.resources.generic_error_message
import org.jetbrains.compose.resources.StringResource

sealed interface ChecklistEditionUIState {
    data object Initial : ChecklistEditionUIState
    data object Loading : ChecklistEditionUIState
    data class Success(
        val checklist: ChecklistViewData
    ) : ChecklistEditionUIState
    data class Error(
        val messageRes: StringResource = Res.string.generic_error_message
    ) : ChecklistEditionUIState
}