package com.example.domain.repository

import com.example.domain.model.baseResponse.ApiResponse
import com.example.domain.model.pokemonItemModel.PokemonItemModel

interface BaseRepository {
    suspend fun getPokemonList(): ApiResponse<PokemonItemModel>
}