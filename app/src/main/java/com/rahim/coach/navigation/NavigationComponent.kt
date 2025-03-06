package com.rahim.coach.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rahim.coach.feature.home.homeScreen

@Composable
fun NavigationComponent(
    navController: NavHostController,
    startDestination: Any,
    innerPadding: PaddingValues,
) {
    NavHost(navController, startDestination = startDestination, Modifier.padding(innerPadding)) {
        homeScreen()
    }
}
