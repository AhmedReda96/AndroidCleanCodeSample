package com.ar.data.repositoryImp

import com.ar.data.apiService.ApiService
import com.ar.domain.repository.BaseRepository

class RepositoryImpl constructor(private val apiService: ApiService) : BaseRepository {
    override suspend fun getPokemonList() = apiService.getPokemon()
}
