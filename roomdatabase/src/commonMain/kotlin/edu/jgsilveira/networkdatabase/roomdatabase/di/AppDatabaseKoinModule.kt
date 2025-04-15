package edu.jgsilveira.networkdatabase.roomdatabase.di

import edu.jgsilveira.networkdatabase.roomdatabase.dao.ChecklistDao
import edu.jgsilveira.networkdatabase.roomdatabase.db.AppDatabase
import edu.jgsilveira.networkdatabase.roomdatabase.db.getRoomDatabase
import org.koin.dsl.module

val appDatabaseKoinModule = module {
    single { getRoomDatabase(builder = get()) }
    factory<ChecklistDao> {
        get<AppDatabase>().provideChecklistDao()
    }
}