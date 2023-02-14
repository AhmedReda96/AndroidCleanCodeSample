package com.example.uctask.ui.routes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.uctask.ui.base.BaseRoutes


@Composable
fun HomeRoute(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(modifier = Modifier.clickable {
            navHostController.navigate(route = BaseRoutes.DetailsRoute.route)
        }, text = "Home Screen", fontSize = MaterialTheme.typography.h3.fontSize)
    }
}

@Composable
@Preview(showBackground = true)
fun HomeRoutePreview() {
    HomeRoute(navHostController = rememberNavController())
}