package edu.jgsilveira.networkdatabase.roomdatabase.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ChecklistWithItemsEntity(
    @Embedded val checklist: ChecklistEntity,
    @Relation(
        parentColumn = "uuid",
        entityColumn = "checklist_uuid"
    )
    val items: List<ChecklistItemEntity>
)
