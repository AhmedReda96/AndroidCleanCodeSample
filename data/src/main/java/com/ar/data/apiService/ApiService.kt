package com.ar.data.apiService

import com.ar.domain.model.baseResponse.ApiResponse
import com.ar.domain.model.pokemonItemModel.PokemonItemModel
import retrofit2.http.GET

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemon(): ApiResponse<List<PokemonItemModel>>
}