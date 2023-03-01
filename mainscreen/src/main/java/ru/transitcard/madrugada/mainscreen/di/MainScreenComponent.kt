package ru.transitcard.madrugada.mainscreen.di

import dagger.Component
import ru.transitcard.madrugada.MainScreenScope

@MainScreenScope
@Component(dependencies = [MainScreenComponentDependencies::class])
interface MainScreenComponent {

    //    fun inject(fragment: TestFragment)
    //
    @Component.Builder
    interface Builder {

        fun deps(deps: MainScreenComponentDependencies): Builder

        fun build(): MainScreenComponent
    }
}