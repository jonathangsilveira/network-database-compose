package edu.jgsilveira.networkdatabase.roomdatabase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "checklist_item",
    foreignKeys = [
        ForeignKey(
            entity = ChecklistEntity::class,
            parentColumns = ["uuid"],
            childColumns = ["checklist_uuid"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ChecklistItemEntity(
    @PrimaryKey
    val uuid: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "checklist_order")
    val checklistOrder: Int,
    @ColumnInfo(
        name = "created_at",
        typeAffinity = ColumnInfo.REAL
    ) val createdAtMillis: Long,
    @ColumnInfo(name = "checklist_uuid")
    val checklistId: String
)
