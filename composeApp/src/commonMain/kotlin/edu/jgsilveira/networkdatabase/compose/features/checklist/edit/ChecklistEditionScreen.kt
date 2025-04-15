package edu.jgsilveira.networkdatabase.compose.features.checklist.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import network_database_compose.composeapp.generated.resources.Res
import network_database_compose.composeapp.generated.resources.generic_error_message
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun EditChecklistScreen(
    viewModel: ChecklistEditionViewModel = koinViewModel(),
    modifier: Modifier = Modifier.fillMaxSize(),
    onSave: () -> Unit = {}
) {
    Box(
        modifier = modifier
    ) {
        val state by viewModel.state.collectAsStateWithLifecycle(
            lifecycleOwner = LocalLifecycleOwner.current,
            initialValue = ChecklistEditionUIState.Initial,
            minActiveState = Lifecycle.State.STARTED
        )
        LaunchedEffect(Unit) {
            viewModel.getChecklist()
        }
        when (state) {
            is ChecklistEditionUIState.Success -> {
                val uiState = state as ChecklistEditionUIState.Success
                FormChecklist(
                    viewData = uiState.checklist,
                    onSave = {
                        viewModel.save()
                    },
                    onTitleChange = { newTitle ->
                        viewModel.updateTitle(newTitle)
                    },
                    modifier = Modifier.fillMaxSize()
                        .padding(all = 16.dp)
                )
            }
            is ChecklistEditionUIState.Error -> {
                val uiState = state as ChecklistEditionUIState.Error
                ErrorChecklist(
                    messageRes = uiState.messageRes,
                    modifier = Modifier.align(
                        alignment = Alignment.Center
                    )
                )
            }
            ChecklistEditionUIState.Initial,
            ChecklistEditionUIState.Loading -> LoadingChecklist(
                modifier = Modifier.align(
                    alignment = Alignment.Center
                )
            )
        }
    }
}

@Composable
fun ChecklistItem() {

}

@Composable
fun LoadingChecklist(
    modifier: Modifier = Modifier
) {
    CircularProgressIndicator(
        modifier = modifier
    )
}

@Composable
fun ErrorChecklist(
    messageRes: StringResource,
    modifier: Modifier = Modifier
) {
    val message = stringResource(messageRes)
    Text(
        message,
        modifier = modifier
    )
}

@Composable
fun FormChecklist(
    viewData: ChecklistViewData,
    modifier: Modifier = Modifier,
    onSave: () -> Unit = {},
    onTitleChange: ((String) -> Unit)? = null,
    onNewItem: (() -> Unit)? = null,
    onCheckItem: (() -> Unit)? = null,
    onItemDescriptionChange: (() -> Unit)? = null
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = onSave
            ) {
                Icon(
                    imageVector = Icons.Filled.Done,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colors.onPrimary,
                    contentDescription = "Save"
                )
            }
            IconButton(
                onClick = {  }
            ) {
                Icon(
                    imageVector = Icons.Filled.Clear,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colors.onPrimary,
                    contentDescription = "Cancel"
                )
            }
        }
        OutlinedTextField(
            value = viewData.title.orEmpty(),
            onValueChange = { onTitleChange?.invoke(it) },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun OnUIAction(
    sharedFlow: SharedFlow<ChecklistEditionUIAction>
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    with(lifecycleOwner) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

            }
        }
    }
}