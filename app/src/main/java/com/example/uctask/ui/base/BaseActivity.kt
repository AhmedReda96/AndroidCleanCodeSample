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
import com.example.uctask.utils.showLog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BaseActivity : BaseViewActivity() {
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
            viewModel.pokemonListLD.collect { viewState -> handleUI(viewState) }
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun handleResponse(response: ApiResponse<*>) {
        when (response.request) {
            is PokemonRequest -> {
                val result = response.data as List<PokemonItemModel>
                showLog("${result.size}")
            }
        }

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
