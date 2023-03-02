package com.ar.sample.ui.base

import com.ar.sample.utils.ConstantStrings

sealed class BaseRoutes(val route: String) {
    object HomeRoute : BaseRoutes(route = ConstantStrings.HOME_ROUTE)
    object DetailsRoute : BaseRoutes(route = ConstantStrings.DETAILS_ROUTE)
}
