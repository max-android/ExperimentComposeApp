package com.testsample.ru.di

import android.content.Context
import com.testsample.ru.data.QuestionnaireStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideIdStore(@ApplicationContext appContext: Context): QuestionnaireStore = QuestionnaireStore(appContext)
}