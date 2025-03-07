package com.rahim.coach.library.designsystem.base

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SpaceDimensions(
    val hairline: Dp = 2.dp,
    val default: Dp = 4.dp,
    val extraSmall: Dp = 8.dp,
    val small: Dp = 12.dp,
    val smallMedium: Dp = 14.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 20.dp,
    val extraLarge: Dp = 24.dp,
    val extraExtraLarge: Dp = 28.dp,
    val extraExtraExtraLarge: Dp = 32.dp,
    val huge: Dp = 36.dp,
    val gigantic: Dp = 40.dp,
)

val LocalSpacing = compositionLocalOf { SpaceDimensions() }