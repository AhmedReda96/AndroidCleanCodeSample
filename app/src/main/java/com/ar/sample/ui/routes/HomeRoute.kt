package com.ar.sample.ui.routes

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.ar.domain.model.baseResponse.ApiResponse
import com.ar.domain.model.pokemonItemModel.PokemonItemModel
import com.ar.domain.model.pokemonItemModel.PokemonRequest
import com.ar.presentation.viewModel.PokemonListVM
import com.ar.sample.theme.AppTheme
import com.ar.sample.ui.base.BaseRoutes
import com.ar.sample.ui.base.BaseViewActivity
import com.ar.sample.utils.ConstantStrings
import com.ar.sample.utils.getImageUrl
import com.ar.sample.utils.showLog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeRoute constructor(
    private val navHostController: NavHostController,
    private val viewModel: PokemonListVM
) : BaseViewActivity() {
    private val pokemonList = mutableStateListOf<PokemonItemModel>()

    @Composable
    fun HomeRouteUI() {
        AppTheme {
            InitVars(viewModel)
            PopulateUI()
        }
    }

    @Composable
    private fun InitVars(viewModel: PokemonListVM) = with(rememberCoroutineScope()) {
        if (pokemonList.isEmpty()) {
            viewModel.getPokemon(PokemonRequest())
            HandleUI(viewState = viewModel.pokemonListSF.collectAsState().value)
        }
    }

    @Composable
    @Suppress("UNCHECKED_CAST")
    override fun HandleResponse(response: ApiResponse<*>) = with(response) {
        when (request) {
            is PokemonRequest -> {
                pokemonList.addAll(response.data as List<PokemonItemModel>)
                showLog(false, "pokemon size : ${pokemonList.size}")
                PopulateUI()
            }
        }
    }

    @Composable
    private fun PopulateUI() {
        LazyColumn {
            items(pokemonList.size) {
                DrawListItem(pokemonList[it])
            }
        }
    }

    @Composable
    fun DrawListItem(pokemonItemModel: PokemonItemModel) {
        Card(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.padding(6.dp)
        ) {
            Box(modifier = Modifier.clickable {
//                navHostController.currentBackStackEntry?.savedStateHandle?.set(
//                    ConstantStrings.POKEMON_ITEM,
//                    pokemonItemModel
//                )
                viewModel.pokemonItemMode.value = pokemonItemModel
                navHostController.navigate(route = BaseRoutes.DetailsRoute.route)
            }) {
                Image(
                    painter = rememberAsyncImagePainter(getImageUrl(pokemonItemModel.url)),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.FillBounds
                )

                Surface(
                    color = MaterialTheme.colors.onSurface.copy(alpha = .3f),
                    modifier = Modifier.align(Alignment.BottomCenter),
                    contentColor = MaterialTheme.colors.surface
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        Text(text = "${pokemonItemModel.name}")
                    }
                }


            }
        }
    }
}