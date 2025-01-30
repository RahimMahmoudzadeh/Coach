package com.rahim.coach.library.navigation

sealed class Destinations(val route:String) {
    data object Home : Destinations(ModuleRoutes.HOME.route)
    data object Bag : Destinations(ModuleRoutes.BAG.route)
    data object Search : Destinations(ModuleRoutes.SEARCH.route)
    data object Profile : Destinations(ModuleRoutes.PROFILE.route)
}
private enum class ModuleRoutes(val route: String) {
    HOME("home"),
    BAG("bag"),
    SEARCH("search"),
    PROFILE("profile"),
}