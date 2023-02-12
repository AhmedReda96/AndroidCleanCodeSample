package com.example.data.di

import com.example.domain.repository.BaseRepository
import com.example.domain.useCase.BaseUseCase
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