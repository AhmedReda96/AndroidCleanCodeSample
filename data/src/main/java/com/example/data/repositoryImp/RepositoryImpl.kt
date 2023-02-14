package com.example.data.repositoryImp

import com.example.data.apiService.ApiService
import com.example.domain.model.baseResponse.ApiResponse
import com.example.domain.model.pokemonItemModel.PokemonItemModel
import com.example.domain.repository.BaseRepository

class RepositoryImpl constructor(private val apiService: ApiService) : BaseRepository {
    override suspend fun getPokemonList() = apiService.getPokemon()
}
