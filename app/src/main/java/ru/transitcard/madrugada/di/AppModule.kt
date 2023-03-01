package ru.transitcard.madrugada.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.transitcard.madrugada.AppScope

@Module
object AppModule{
    @AppScope
    @Provides
    fun provideContext(context: Context): Context = context
}
