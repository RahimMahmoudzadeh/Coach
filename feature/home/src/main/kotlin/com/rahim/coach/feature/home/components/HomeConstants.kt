package com.rahim.coach.feature.home.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.coach.feature.home.R

object HomeConstants {
    val DEF_CARD_ELEVATION = 6.dp

    val primaryArcCarouselItemsSample = listOf(
        "Food",
        "Regime",
        "Yoga",
        "Calories",
        "Exercise"
    )

    val arcCarouselCardFoodItemsSample = listOf("Breakfast", "Lunch", "Dinner", "Snack")
    val arcCarouselCardFoodDaySample = listOf("Morning", "Afternoon", "Evening")
    val arcCarouselCardFoodYogaSample = listOf("Sleep", "Gratitude")

    val demoPromoSlides = listOf(
        PromoSlide(
            backgroundColor = Color(0xFFFF9800), // Orange
            secondaryColor = Color(0xFFFFC107),  // Lighter orange
            imageRes = R.drawable.food, // e.g. bananas + coconut
            smallTitle = "Today is a different..",
            bigTitle = "Special finger ..."
        ),
        PromoSlide(
            backgroundColor = Color(0xFF2196F3), // Blue
            secondaryColor = Color(0xFF64B5F6),  // Lighter blue
            imageRes = R.drawable.food,
            smallTitle = "Daily sports",
            bigTitle = "Stay with Coach"
        ),
    )

    val demoFoodCardItems = listOf(
        FoodCardItem(
            imageRes = R.drawable.food,
            title = "Noodles with spicy seasoning",
            subtitle = "Rice, various vegetables",
            time = "60 minutes",
            calories = "24 calories"
        ),
        FoodCardItem(
            imageRes = R.drawable.food,
            title = "Noodles with spicy seasoning",
            subtitle = "Rice, various vegetables",
            time = "60 minutes",
            calories = "24 calories",
            isFavorite = true
        ),
        FoodCardItem(
            imageRes = R.drawable.food,
            title = "Noodles with spicy seasoning",
            subtitle = "Rice, various vegetables",
            time = "60 minutes",
            calories = "24 calories",
            isFavorite = true
        ),
        FoodCardItem(
            imageRes = R.drawable.food,
            title = "Noodles with spicy seasoning",
            subtitle = "Rice, various vegetables",
            time = "60 minutes",
            calories = "24 calories",
            isFavorite = true
        ),
        FoodCardItem(
            imageRes = R.drawable.food,
            title = "Noodles with spicy seasoning",
            subtitle = "Rice, various vegetables",
            time = "60 minutes",
            calories = "24 calories",
            isFavorite = true
        ),
    )
}
