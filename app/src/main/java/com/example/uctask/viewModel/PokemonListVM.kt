package com.example.uctask.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.baseViewState.NetworkingViewState
import com.example.domain.model.pokemonItemModel.PokemonRequest
import com.example.domain.useCase.BaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListVM @Inject constructor(private val baseUseCase: BaseUseCase) : ViewModel() {
    private var _pokemonListMLD =
        MutableStateFlow<NetworkingViewState>(NetworkingViewState.Loading())
    val pokemonListLD: StateFlow<NetworkingViewState> get() = _pokemonListMLD


    fun getPokemon(scanSupplier: PokemonRequest, loading: NetworkingViewState.Loading) {
        viewModelScope.launch {
            try {
                _pokemonListMLD.emit(loading)
                _pokemonListMLD.emit(
                    NetworkingViewState.Success(
                        scanSupplier,
                        baseUseCase.invoke(),
                        loading
                    )
                )

            } catch (e: Exception) {
                e.printStackTrace()
                _pokemonListMLD.emit(NetworkingViewState.Error(e, loading))
            }
        }
    }


}