package com.example.uctask.ui.base

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.domain.model.baseResponse.ApiResponse
import com.example.domain.model.baseViewState.NetworkingViewState
import com.example.domain.model.pokemonItemModel.PokemonItemModel
import com.example.domain.model.pokemonItemModel.PokemonRequest
import com.example.presentation.viewModel.PokemonListVM
import com.example.uctask.theme.UCTaskTheme
import com.example.uctask.theme.widget.NormalText
import com.example.uctask.ui.routes.DetailsRoute
import com.example.uctask.ui.routes.HomeRoute
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BaseActivity : ComponentActivity() {
    private val viewModel: PokemonListVM by viewModels()
    private lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UCTaskTheme {
                initVars()
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }

    @Composable
    fun SetupNavGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            startDestination = BaseRoutes.HomeRoute.route
        ) {
            composable(route = BaseRoutes.HomeRoute.route) { HomeRoute(navController) }
            composable(route = BaseRoutes.DetailsRoute.route) { DetailsRoute(navController) }
        }
    }


    private fun initVars() {
        viewModel.getPokemon(PokemonRequest())
        lifecycleScope.launch {
            viewModel.pokemonListLD.collect { viewState ->
                when (viewState) {
                    is NetworkingViewState.Loading -> {
                    }

                    is NetworkingViewState.Error -> {
                        try {
                            Log.d("TAG", "handleResponse: ${viewState.error.printStackTrace()}")
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }

                    is NetworkingViewState.Success<*> -> {
                        (viewState.item as ApiResponse<*>).request = viewState.request
                        handleResponse(viewState.item as ApiResponse<*>)
                    }
                }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun handleResponse(response: ApiResponse<*>) {
        // PopulateUI()
        val result = response.data as List<PokemonItemModel>
        Log.d("TAG", "handleResponse: ${result.size}")
        Log.d("TAG", "handleResponse: ${response.request}")
    }

    @Composable
    private fun PopulateUI() {
        LazyColumn {
            items(500) {
                NormalText(it.toString())
            }
        }
    }
}
