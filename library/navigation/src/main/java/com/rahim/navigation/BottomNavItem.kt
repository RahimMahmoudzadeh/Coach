package com.rahim.navigation

import androidx.annotation.DrawableRes
import com.rahim.coach.library.navigation.R

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
