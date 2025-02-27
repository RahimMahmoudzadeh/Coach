package com.rahim.coach.library.designsystem.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

object ThemeConstants {
    val DEF_CARD_ELEVATION = 6.dp

    val primaryArcCarouselItemsSample = listOf(
        "Food",
        "Regime",
        "Yoga",
        "Calories",
        "Exercise"
    )

    object Dimensions {
        val defaultCornerRadius = 10.dp
    }



    object Colors {
        val CoachGreen = Color(0xFF00D27D)
        val IconColor = Color(0xFF292D32)
        val BorderColor = Color(0xFFACACAC)
        val TitleColor = Color(0xFF484848)
        val LabelColor = Color(0xFF4C4C4C)
        val BodyColor = Color(0xFF6F6F6F)
    }
    object CoachFont {
        val inter = FontFamily(
            Font(com.rahim.coach.library.designsystem.R.font.inter_regular, FontWeight.Normal),
            Font(com.rahim.coach.library.designsystem.R.font.inter_semi_bold, FontWeight.SemiBold),
            Font(com.rahim.coach.library.designsystem.R.font.inter_bold, FontWeight.Bold),
        )

    }
}
