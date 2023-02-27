package com.example.uctask.ui.base

import com.example.uctask.utils.ConstantStrings

sealed class BaseRoutes(val route: String) {
    object HomeRoute : BaseRoutes(route = ConstantStrings.HOME_ROUTE)
    object DetailsRoute : BaseRoutes(route = ConstantStrings.DETAILS_ROUTE)
}
