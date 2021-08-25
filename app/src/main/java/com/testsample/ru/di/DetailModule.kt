package com.testsample.ru.di

import com.testsample.ru.data.DetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DetailModule {

    @Provides
    @ViewModelScoped
    fun provideDetailRepository(): DetailRepository = DetailRepository()

}