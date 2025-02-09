package com.rahim.coach.feature.register.home.components

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

    object HomeColors {
        val CoachGreen = Color(0xFF00D27D)
        val IconColor = Color(0xFF292D32)
        val BorderColor = Color(0xFFACACAC)
        val TitleColor = Color(0xFF484848)
        val BodyColor = Color(0xFFC4C4C4)
    }
    object HomeFont {
        val inter = FontFamily(
            Font(R.font.inter_regular, FontWeight.Normal),
            Font(R.font.inter_semi_bold, FontWeight.SemiBold),
            Font(R.font.inter_bold, FontWeight.Bold),
        )

        val homeSemiBold = TextStyle(
            fontFamily = HomeFont.inter,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }
}
