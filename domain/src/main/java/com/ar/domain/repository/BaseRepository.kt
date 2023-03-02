package com.ar.domain.repository

import com.ar.domain.model.baseResponse.ApiResponse
import com.ar.domain.model.pokemonItemModel.PokemonItemModel

interface BaseRepository {
    suspend fun getPokemonList(): ApiResponse<List<PokemonItemModel>>
}