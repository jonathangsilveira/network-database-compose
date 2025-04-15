package edu.jgsilveira.networkdatabase.compose

import android.app.Application
import edu.jgsilveira.networkdatabase.compose.features.checklist.edit.checklistEditionKoinModule
import edu.jgsilveira.networkdatabase.roomdatabase.di.appDatabaseBuilderKoinModule
import edu.jgsilveira.networkdatabase.roomdatabase.di.appDatabaseKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NetworkDatabaseComposeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                module {
                    androidContext(this@NetworkDatabaseComposeApp)
                },
                appDatabaseBuilderKoinModule,
                appDatabaseKoinModule,
                checklistEditionKoinModule
            )
        }
    }
}