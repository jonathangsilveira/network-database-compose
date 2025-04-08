package edu.jgsilveira.networkdatabase.roomdatabase.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ChecklistWithItemsEntity(
    @Embedded val user: ChecklistEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "checklist_id"
    )
    val items: List<ChecklistItemEntity>
)
