package edu.iesam.pmdm_mayo.app

import android.app.Application
import edu.iesam.pmdm_mayo.app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PmdmMayoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PmdmMayoApplication)
            modules()
        }
    }
}