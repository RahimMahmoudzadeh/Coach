package com.rahim.coach.library.navigation.component

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.rahim.coach.library.designsystem.R
import com.rahim.coach.library.navigation.Destinations
import com.rahim.coach.library.navigation.Destinations.Home

data class BottomNavigationRoute<T : Any>(
    val name: String,
    val route: T,
    val icon: ImageVector,
)

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    navBackStackEntry: NavBackStackEntry?,
) {
    val screenItems = listOf(
        BottomNavigationRoute(
            stringResource(R.string.home),
            Home,
            ImageVector.vectorResource(com.rahim.coach.library.navigation.R.drawable.ic_home)
        ),
        BottomNavigationRoute(
            stringResource(R.string.bag),
            Destinations.Bag,
            ImageVector.vectorResource(com.rahim.coach.library.navigation.R.drawable.ic_bag)
        ),
        BottomNavigationRoute(
            stringResource(R.string.search),
            Destinations.Search,
            ImageVector.vectorResource(com.rahim.coach.library.navigation.R.drawable.ic_search_normal)
        ),
        BottomNavigationRoute(
            stringResource(R.string.profile),
            Destinations.Profile,
            ImageVector.vectorResource(com.rahim.coach.library.navigation.R.drawable.ic_user)
        ),
    )

    val currentDestination = navBackStackEntry?.destination
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primary,
    ) {
        screenItems.forEach { screen ->
            val currentRoute = currentDestination?.route?.split(".")
            val isCurrentRoute = currentRoute?.find {
                it == screen.route.toString()
            } != null

            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.onPrimary,
                ),
                onClick = {
                    navController.navigateSingleTopTo(screen.route)
                },
                icon = {
                    Icon(
                        tint = Color.White,
                        imageVector = screen.icon,
                        contentDescription = screen.name
                    )
                },
                selected = isCurrentRoute,
            )
        }
    }
}

fun <T : Any> NavHostController.navigateSingleTopTo(route: T) {
    navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}