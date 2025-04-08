package edu.jgsilveira.networkdatabase.roomdatabase.entity

import androidx.room.Entity

@Entity(tableName = "reminder_schedule")
data class ReminderScheduleEntity(
    val id: Long,
    val scheduleTimeMillis: Long
)
