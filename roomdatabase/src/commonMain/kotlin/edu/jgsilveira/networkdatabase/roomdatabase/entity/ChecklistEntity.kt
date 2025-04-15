package edu.jgsilveira.networkdatabase.roomdatabase.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "checklist"
)
data class ChecklistEntity(
    @PrimaryKey(autoGenerate = false)
    val uuid: String,
    @ColumnInfo(
        name = "id",
        defaultValue = "0"
    )
    val id: Long,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo(
        name = "created_at",
        typeAffinity = ColumnInfo.REAL
    ) val createdAtMillis: Long
)