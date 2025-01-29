package com.rahim.designsystem.base

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class SizeDimensions(
    val default: Dp = 12.dp,
    val extraSmall: Dp = 16.dp,
    val small: Dp = 20.dp,
    val medium: Dp = 24.dp,
    val large: Dp = 28.dp,
    val extraLarge: Dp = 32.dp,
    val extraExtraLarge: Dp = 36.dp,
    val extraExtraExtraLarge: Dp = 40.dp,
    val huge: Dp = 44.dp,
    val gigantic: Dp = 48.dp,
    val extraExtraHuge: Dp = 52.dp,
    val extraExtraExtraHuge: Dp = 56.dp,
    val extraExtraExtraExtraHuge: Dp = 60.dp,
)

val LocalSize = compositionLocalOf { SizeDimensions() }