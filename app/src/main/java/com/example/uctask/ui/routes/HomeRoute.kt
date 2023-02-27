package com.example.uctask.ui.routes

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
import com.example.domain.model.baseResponse.ApiResponse
import com.example.domain.model.pokemonItemModel.PokemonItemModel
import com.example.domain.model.pokemonItemModel.PokemonRequest
import com.example.presentation.viewModel.PokemonListVM
import com.example.uctask.theme.UCTaskTheme
import com.example.uctask.ui.base.BaseRoutes
import com.example.uctask.ui.base.BaseViewActivity
import com.example.uctask.utils.getImageUrl
import com.example.uctask.utils.showLog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class HomeRoute constructor(
    private val navHostController: NavHostController,
    private val viewModel: PokemonListVM
) : BaseViewActivity() {
    private val pokemonList = mutableStateListOf<PokemonItemModel>()

    @Composable
    open fun HomeRouteUI() {
        UCTaskTheme {
            InitVars(viewModel)
            PopulateUI()
        }
    }

    @Composable
    private fun InitVars(viewModel: PokemonListVM) = with(rememberCoroutineScope()) {
        viewModel.getPokemon(PokemonRequest())
        HandleUI(viewState = viewModel.pokemonListSF.collectAsState().value)
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