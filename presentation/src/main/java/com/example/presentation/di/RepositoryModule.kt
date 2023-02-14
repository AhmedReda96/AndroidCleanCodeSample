package com.example.presentation.di

import com.example.data.apiService.ApiService
import com.example.data.repositoryImp.RepositoryImpl
import com.example.domain.repository.BaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun getRepository(apiService: ApiService):BaseRepository{
        return RepositoryImpl(apiService)
    }
}