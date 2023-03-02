package com.ar.presentation.di

import com.ar.domain.repository.BaseRepository
import com.ar.domain.useCase.BaseUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun getUseCase(repository: BaseRepository): BaseUseCase {
        return BaseUseCase(repository)
    }
}