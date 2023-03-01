package ru.transitcard.madrugada.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.transitcard.madrugada.AppScope
import ru.transitcard.madrugada.MainActivity
import ru.transitcard.madrugada.mainscreen.di.MainScreenComponent

@Component(
    modules = [AppModule::class],
    dependencies = [AppComponentDependencies::class]
)
@AppScope
interface AppComponent : MainScreenComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun appComponentDependencies(dependencies: AppComponentDependencies): Builder

        fun build(): AppComponent
    }

    fun inject(application: MainActivity)
}