package edu.jgsilveira.networkdatabase.roomdatabase.di

import androidx.room.Room
import androidx.room.RoomDatabase
import edu.jgsilveira.networkdatabase.roomdatabase.db.AppDatabase
import edu.jgsilveira.networkdatabase.roomdatabase.db.DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val appDatabaseBuilderKoinModule = module {
    factory<RoomDatabase.Builder<AppDatabase>> {
        val appContext = androidContext().applicationContext
        val dbFile = appContext.getDatabasePath(DATABASE_NAME)
        Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}