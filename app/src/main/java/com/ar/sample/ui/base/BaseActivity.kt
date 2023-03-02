package com.ar.sample.ui.base

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ar.domain.model.pokemonItemModel.PokemonItemModel
import com.ar.presentation.viewModel.PokemonListVM
import com.ar.sample.theme.AppTheme
import com.ar.sample.ui.routes.DetailsRoute
import com.ar.sample.ui.routes.HomeRoute
import com.ar.sample.utils.ConstantStrings
import com.ar.sample.utils.showLog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BaseActivity : BaseViewActivity() {
    private lateinit var navController: NavHostController
    private val viewModel: PokemonListVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
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
                HomeRoute(navHostController = navController, viewModel).HomeRouteUI()
            }
            composable(
                route = BaseRoutes.DetailsRoute.route
            ) {
                DetailsRoute(
                    navHostController = navController,
                    viewModel
                ).DetailsRouteUI()
            }
        }
    }
}
