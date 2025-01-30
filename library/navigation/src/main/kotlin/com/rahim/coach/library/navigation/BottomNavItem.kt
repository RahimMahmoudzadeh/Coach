package com.rahim.coach.library.navigation

import androidx.annotation.DrawableRes

sealed class BottomNavItem(
    val route: String,
    @DrawableRes val icon: Int?,
) {
    data object Home : BottomNavItem(
        Destinations.Home.route,
        R.drawable.iv_home,
    )

    data object Bag : BottomNavItem(
        Destinations.Bag.route,
        R.drawable.iv_bag,
    )

    data object Search : BottomNavItem(
        Destinations.Search.route,
        R.drawable.iv_search_normal
    )
    data object Profile : BottomNavItem(
        Destinations.Profile.route,
        R.drawable.iv_user
    )
}
