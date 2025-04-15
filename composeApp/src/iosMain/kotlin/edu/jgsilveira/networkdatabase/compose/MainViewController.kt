package edu.jgsilveira.networkdatabase.compose

import androidx.compose.ui.window.ComposeUIViewController
import edu.jgsilveira.networkdatabase.roomdatabase.di.appDatabaseBuilderKoinModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        startKoin {
            modules(
                appDatabaseBuilderKoinModule,
                appDatabaseBuilderKoinModule
            )
        }
    }
) { App() }