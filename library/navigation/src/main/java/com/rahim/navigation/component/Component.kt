package com.rahim.navigation.component

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.rahim.navigation.BottomNavItem

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
) {
    val screenItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Bag,
        BottomNavItem.Search,
        BottomNavItem.Profile,
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.onBackground,
    ) {
        screenItems.forEach { screen ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navController.navigateSingleTopTo(screen.route)
                },
                icon = {
                    Icon(
                        tint = MaterialTheme.colorScheme.secondary,
                        painter = painterResource(
                            id = screen.icon?:0
                        ),
                        contentDescription = screen.route
                    )
                },
                selected = navController.currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
            )
        }
    }

}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }