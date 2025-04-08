package edu.jgsilveira.networkdatabase.roomdatabase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ReminderScheduleEntity

@Dao
abstract class ReminderScheduleDao {
    @Query("SELECT * FROM ReminderScheduleEntity")
    abstract suspend fun getAllScheduledReminders(): List<ReminderScheduleEntity>

    @Query("SELECT * FROM ReminderScheduleEntity")
    abstract suspend fun getScheduledReminderById(
        id: Long
    ): List<ReminderScheduleEntity>

    @Upsert
    abstract suspend fun upsertReminderSchedule(
        reminderSchedule: ReminderScheduleEntity
    )

    @Delete(ReminderScheduleEntity::class)
    abstract suspend fun clearScheduledReminders()

    @Delete(ReminderScheduleEntity::class)
    abstract suspend fun removeScheduledReminders(vararg id: Int)
}