package com.ar.sample.ui.routes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.ar.presentation.viewModel.PokemonListVM
import com.ar.sample.theme.AppTheme
import com.ar.sample.ui.base.BaseRoutes
import com.ar.sample.ui.base.BaseViewActivity
import com.ar.sample.utils.ConstantStrings
import com.ar.sample.utils.getImageUrl

class DetailsRoute(
    private val navHostController: NavHostController, private val viewModel: PokemonListVM
) : BaseViewActivity() {

    @Composable
    fun DetailsRouteUI() {
        AppTheme {
            BuildUI()
        }
    }

    @Composable
    fun BuildUI() {
        Box(modifier = Modifier.clickable {
            navHostController.navigate(route = BaseRoutes.DetailsRoute.route)
        }) {
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
                    Image(
                        painter = rememberAsyncImagePainter(
                            getImageUrl(
                                viewModel.pokemonItemMode.collectAsState().value?.url.toString()
                            )
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.FillBounds
                    )
                    Text(text = viewModel.pokemonItemMode.collectAsState().value?.name.toString())
                }
            }
        }
    }
}