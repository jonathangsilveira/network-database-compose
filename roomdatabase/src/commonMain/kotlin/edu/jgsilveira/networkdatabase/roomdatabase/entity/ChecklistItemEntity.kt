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
            parentColumns = ["id"],
            childColumns = ["checklist_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ChecklistItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "created_at_millis")
    val checklistOrder: Int,
    @ColumnInfo(
        name = "created_at",
        typeAffinity = ColumnInfo.REAL
    ) val createdAtMillis: Long,
    @ColumnInfo(name = "checklist_id")
    val checklistId: Int
)
