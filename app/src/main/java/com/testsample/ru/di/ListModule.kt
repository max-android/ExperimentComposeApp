package com.testsample.ru.di

import com.testsample.ru.data.ListRepository
import com.testsample.ru.data.MainRepository
import com.testsample.ru.data.QuestionnaireStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ListModule {

    @Provides
    @ViewModelScoped
    fun provideListRepository(): ListRepository = ListRepository()
}