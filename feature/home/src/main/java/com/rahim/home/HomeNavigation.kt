package com.rahim.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.rahim.navigation.Destinations
import kotlinx.serialization.Serializable

@Serializable
object Home

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(Home, navOptions)
}

fun NavGraphBuilder.homeScreen() {
    composable<Home> {
        HomeRoute()
    }
}