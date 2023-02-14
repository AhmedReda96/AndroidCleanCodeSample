package com.example.uctask.ui.base

import androidx.compose.ui.unit.Constraints
import com.example.uctask.utils.ConstantStrings

sealed class BaseRoutes(val route: String) {
    object HomeRoute : BaseRoutes(route = ConstantStrings.homeRoute)
    object DetailsRoute : BaseRoutes(route = ConstantStrings.detailsRoute)
}
