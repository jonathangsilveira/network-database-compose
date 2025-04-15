package edu.jgsilveira.networkdatabase.roomdatabase.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ChecklistEntity
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ChecklistItemEntity
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ChecklistWithItemsEntity

@Dao
abstract class ChecklistDao {
    @Query("SELECT * FROM checklist")
    abstract suspend fun getChecklistsWithItems(): List<ChecklistWithItemsEntity>

    @Transaction
    @Query("SELECT * FROM checklist WHERE uuid = :checklistUuid")
    abstract suspend fun getChecklistWithItems(checklistUuid: String): ChecklistWithItemsEntity?

    @Upsert
    abstract suspend fun upsertChecklist(checklist: ChecklistEntity)

    @Upsert
    abstract suspend fun upsertChecklistItem(checklistItem: ChecklistItemEntity)

    @Query("DELETE FROM checklist WHERE 1 = 1")
    abstract suspend fun clearChecklists()

    @Query("DELETE FROM checklist WHERE id in (:uuid)")
    abstract suspend fun removeChecklistByUuid(vararg uuid: String)
}