package edu.jgsilveira.networkdatabase.compose.features.checklist.edit

import edu.jgsilveira.networkdatabase.compose.mapper.DataMapper
import edu.jgsilveira.networkdatabase.roomdatabase.db.generateUuidKey
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ChecklistEntity
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

class SingleChecklistDataMapper : DataMapper<ChecklistViewData, ChecklistEntity> {

    override fun toEntity(
        model: ChecklistViewData
    ): ChecklistEntity = with(model) {
        ChecklistEntity(
            uuid = uuid ?: generateUuidKey(),
            id = checklistId,
            title = title.orEmpty(),
            createdAtMillis = createdAt?.toEpochMilliseconds()
                ?: Clock.System.now().toEpochMilliseconds()
        )
    }

    override fun toModel(
        entity: ChecklistEntity
    ): ChecklistViewData = with(entity) {
        ChecklistViewData(
            uuid = uuid,
            checklistId = id,
            title = title,
            createdAt = Instant.fromEpochMilliseconds(
                createdAtMillis
            )
        )
    }
}