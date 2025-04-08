package edu.jgsilveira.networkdatabase.roomdatabase.di

import androidx.room.Room
import androidx.room.RoomDatabase
import edu.jgsilveira.networkdatabase.roomdatabase.db.AppDatabase
import edu.jgsilveira.networkdatabase.roomdatabase.db.DATABASE_NAME
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.dsl.module
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual val appDatabaseBuilderKoinModule = module {
    factory<RoomDatabase.Builder<AppDatabase>> {
        val dbFilePath = documentDirectory() + "/$DATABASE_NAME"
        Room.databaseBuilder<AppDatabase>(
            name = dbFilePath
        )
    }
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}