package edu.jgsilveira.networkdatabase.roomdatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ChecklistEntity
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ChecklistItemEntity
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ChecklistWithItemsEntity

@Dao
abstract class ChecklistDao {
    @Query("SELECT * FROM ChecklistEntity")
    abstract suspend fun getChecklistsWithItems(): List<ChecklistWithItemsEntity>

    @Transaction
    @Query("SELECT * FROM ChecklistEntity WHERE checklist_id = :checklistId")
    abstract suspend fun getChecklistWithItems(checklistId: Int): ChecklistWithItemsEntity?

    @Upsert
    abstract suspend fun upsertChecklist(checklist: ChecklistEntity)

    @Upsert
    abstract suspend fun upsertChecklistItem(checklistItem: ChecklistItemEntity)

    @Transaction
    suspend fun upsertChecklistItems(checklistItems: List<ChecklistItemEntity>) {
        checklistItems.forEach { item ->
            upsertChecklistItem(item)
        }
    }

    @Delete(ChecklistEntity::class)
    abstract suspend fun clearChecklists()

    @Delete(ChecklistEntity::class)
    abstract suspend fun removeChecklistById(vararg id: Int)
}