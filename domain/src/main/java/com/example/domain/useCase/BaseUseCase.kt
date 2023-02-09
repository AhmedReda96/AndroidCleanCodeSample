package com.example.domain.useCase

import com.example.domain.repository.BaseRepository

class BaseUseCase(private val repo: BaseRepository) {
    suspend operator fun invoke() = repo.getPokemonList()
}