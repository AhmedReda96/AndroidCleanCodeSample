package com.ar.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ar.domain.model.baseViewState.NetworkingViewState
import com.ar.domain.model.pokemonItemModel.PokemonItemModel
import com.ar.domain.model.pokemonItemModel.PokemonRequest
import com.ar.domain.useCase.BaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListVM @Inject constructor(private val baseUseCase: BaseUseCase) : ViewModel() {
    private var _pokemonListMSF =
        MutableStateFlow<NetworkingViewState>(NetworkingViewState.Loading())
    val pokemonListSF: StateFlow<NetworkingViewState> get() = _pokemonListMSF
    val pokemonItemMode = MutableStateFlow<PokemonItemModel?>(null)

    fun getPokemon(scanSupplier: PokemonRequest) {
        viewModelScope.launch {
            try {
                _pokemonListMSF.emit(
                    NetworkingViewState.Success(
                        scanSupplier,
                        baseUseCase.getPokemonList()
                    )
                )

            } catch (e: Exception) {
                e.printStackTrace()
                _pokemonListMSF.emit(NetworkingViewState.Error(e))
            }
        }
    }


}