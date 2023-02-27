package com.example.uctask.ui.base

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.domain.model.baseResponse.ApiResponse
import com.example.domain.model.pokemonItemModel.PokemonItemModel
import com.example.domain.model.pokemonItemModel.PokemonRequest
import com.example.presentation.viewModel.PokemonListVM
import com.example.uctask.theme.UCTaskTheme
import com.example.uctask.ui.routes.DetailsRoute
import com.example.uctask.ui.routes.HomeRoute
import com.example.uctask.utils.showLog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BaseActivity : BaseViewActivity() {
    private lateinit var navController: NavHostController
   private val viewModel:PokemonListVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UCTaskTheme {
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
            composable(route = BaseRoutes.HomeRoute.route) {
                HomeRoute(navHostController = navController,viewModel).HomeRouteUI()
            }
            composable(route = BaseRoutes.DetailsRoute.route) { DetailsRoute(navController) }
        }
    }
}
