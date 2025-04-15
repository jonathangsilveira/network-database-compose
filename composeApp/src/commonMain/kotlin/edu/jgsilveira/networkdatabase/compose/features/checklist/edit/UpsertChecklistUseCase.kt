package edu.jgsilveira.networkdatabase.compose.features.checklist.edit

import edu.jgsilveira.networkdatabase.roomdatabase.dao.ChecklistDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpsertChecklistUseCase(
    private val dao: ChecklistDao,
    private val dataMapper: SingleChecklistDataMapper,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend operator fun invoke(checklist: ChecklistViewData): Result<String> {
        return runCatching {
            val entity = dataMapper.toEntity(checklist)
            withContext(dispatcher) {
                dao.upsertChecklist(entity)
            }
            entity.uuid
        }
    }
}