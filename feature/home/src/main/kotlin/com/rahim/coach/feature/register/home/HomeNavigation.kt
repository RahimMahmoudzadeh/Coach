package com.rahim.coach.feature.register.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.rahim.coach.library.navigation.Destinations

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(Destinations.Home, navOptions)
}

fun NavGraphBuilder.homeScreen() {
  composable<Destinations.Home> {
      HomeRoute()
  }
}
