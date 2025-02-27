package com.rahim.coach.library.navigation

import kotlinx.serialization.Serializable

sealed interface Destinations {
    @Serializable
    data object Bag: Destinations

    @Serializable
    data object Search : Destinations

    @Serializable
    data object Profile : Destinations

    @Serializable
    data object Home : Destinations
}