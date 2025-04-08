package edu.jgsilveira.networkdatabase.roomdatabase.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import edu.jgsilveira.networkdatabase.roomdatabase.dao.ChecklistDao
import edu.jgsilveira.networkdatabase.roomdatabase.dao.ReminderScheduleDao
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ChecklistEntity
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ChecklistItemEntity
import edu.jgsilveira.networkdatabase.roomdatabase.entity.ReminderScheduleEntity

const val DATABASE_NAME = "my_room.db"

@Database(
    version = 1,
    entities = [
        ChecklistEntity::class,
        ChecklistItemEntity::class,
        ReminderScheduleEntity::class
    ]
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun provideChecklistDao(): ChecklistDao
    abstract fun provideReminderScheduleDao(): ReminderScheduleDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .addMigrations()
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .build()
}