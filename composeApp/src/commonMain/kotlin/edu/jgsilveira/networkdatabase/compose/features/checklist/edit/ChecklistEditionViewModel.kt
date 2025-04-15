package edu.jgsilveira.networkdatabase.compose.features.checklist.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.jgsilveira.networkdatabase.compose.features.checklist.list.GetChecklistByIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import network_database_compose.composeapp.generated.resources.Res
import network_database_compose.composeapp.generated.resources.get_checklist_error_message

class ChecklistEditionViewModel(
    private var checklistUuid: String,
    private val getChecklistById: GetChecklistByIdUseCase,
    private val upsertChecklist: UpsertChecklistUseCase
) : ViewModel() {
    private val mutableState = MutableStateFlow<ChecklistEditionUIState>(
        ChecklistEditionUIState.Initial
    )
    val state: StateFlow<ChecklistEditionUIState> = mutableState

    fun getChecklist() {
        viewModelScope.launch {
            mutableState.value = ChecklistEditionUIState.Loading
            getChecklistById(checklistUuid)
                .onFailure {
                    mutableState.value = ChecklistEditionUIState.Error(
                        Res.string.get_checklist_error_message
                    )
                    println("Error on get checklist: ${it.message}")
                }
                .onSuccess { viewData ->
                    mutableState.value = ChecklistEditionUIState.Success(
                        checklist = viewData
                    )
                }
        }
    }

    fun updateTitle(title: String?) {
        viewModelScope.launch {
            mutableState.update { state ->
                if (state is ChecklistEditionUIState.Success) {
                    val viewData = state.checklist.copy(
                        title = title
                    )
                    state.copy(
                        checklist = viewData
                    )
                } else {
                    state
                }
            }
        }
    }

    fun save() {
        viewModelScope.launch {
            val state = mutableState.value as? ChecklistEditionUIState.Success
            state?.let {
                upsertChecklist(it.checklist)
                    .onFailure { error ->
                        println("Error on saving checklist: ${error.message}")
                    }
                    .onSuccess { uuid ->
                        if (checklistUuid != uuid) {
                            checklistUuid = uuid
                            getChecklist()
                        }
                    }
            }
        }
    }
}