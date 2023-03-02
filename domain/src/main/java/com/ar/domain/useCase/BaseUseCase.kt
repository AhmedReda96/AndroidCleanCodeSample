package com.ar.domain.useCase

import com.ar.domain.repository.BaseRepository

class BaseUseCase(private val repo: BaseRepository) {
    suspend  fun getPokemonList() = repo.getPokemonList()
}