package edu.jgsilveira.networkdatabase.compose.features.checklist.list

import edu.jgsilveira.networkdatabase.compose.features.checklist.edit.ChecklistViewData
import edu.jgsilveira.networkdatabase.compose.features.checklist.edit.SingleChecklistDataMapper
import edu.jgsilveira.networkdatabase.roomdatabase.dao.ChecklistDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetChecklistByIdUseCase(
    private val dao: ChecklistDao,
    private val dataMapper: SingleChecklistDataMapper,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend operator fun invoke(checklistUuid: String): Result<ChecklistViewData> {
        return runCatching {
            val entity = withContext(dispatcher) {
                dao.getChecklistWithItems(checklistUuid)
            }
            entity?.let {
                dataMapper.toModel(it.checklist)
            } ?: ChecklistViewData()
        }
    }
}