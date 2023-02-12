package com.example.data.apiService

import com.example.domain.model.baseResponse.ApiResponse
import com.example.domain.model.pokemonItemModel.PokemonItemModel
import retrofit2.http.GET

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemon() : ApiResponse<PokemonItemModel>
}