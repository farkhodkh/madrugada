package ru.transitcard.madrugada

import android.app.Application
import android.content.Context
import ru.transitcard.madrugada.di.AppComponent
import ru.transitcard.madrugada.di.AppComponentDependencies
import ru.transitcard.madrugada.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        App.appComponent = DaggerAppComponent
            .builder()
            .application(this)
            .appComponentDependencies(AppComponentDependenciesImpl())
            .build()
    }

    private inner class AppComponentDependenciesImpl: AppComponentDependencies {
        override val context: Context = this@App
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainActivity -> {
            App.appComponent
        }
        else -> {
            this.applicationContext.appComponent
        }
    }