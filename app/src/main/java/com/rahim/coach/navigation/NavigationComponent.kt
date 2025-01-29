package com.rahim.coach.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rahim.home.homeScreen

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
