package com.ar.presentation.di

import com.ar.data.apiService.ApiService
import com.ar.data.repositoryImp.RepositoryImpl
import com.ar.domain.repository.BaseRepository
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