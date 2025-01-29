package com.rahim.designsystem.base

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class FontDimensions(
    val default: TextUnit = 12.sp,
    val small: TextUnit = 16.sp,
    val medium: TextUnit = 18.sp,
    val large: TextUnit = 20.sp,
    val extraLarge: TextUnit = 24.sp,
    val huge: TextUnit = 32.sp,
    val gigantic: TextUnit = 40.sp,
)

val LocalFontSize = compositionLocalOf { FontDimensions() }