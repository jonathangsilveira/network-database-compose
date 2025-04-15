package edu.jgsilveira.networkdatabase.compose.features.checklist.edit

import edu.jgsilveira.networkdatabase.compose.features.checklist.list.GetChecklistByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val checklistEditionKoinModule = module {
    viewModel { (checklistUuid: String) ->
        ChecklistEditionViewModel(
            checklistUuid = checklistUuid,
            getChecklistById = GetChecklistByIdUseCase(
                dao = get(),
                dataMapper = SingleChecklistDataMapper(),
                dispatcher = Dispatchers.IO
            ),
            upsertChecklist = UpsertChecklistUseCase(
                dao = get(),
                dataMapper = SingleChecklistDataMapper(),
                dispatcher = Dispatchers.IO
            )
        )
    }
}