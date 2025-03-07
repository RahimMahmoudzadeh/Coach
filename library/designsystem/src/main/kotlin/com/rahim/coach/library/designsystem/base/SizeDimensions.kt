package com.rahim.coach.library.designsystem.base

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines a set of standard size dimensions for consistent spacing and layout.
 *
 * @property default The smallest unit of spacing, typically used for fine adjustments (4dp).
 * @property extraExtraExtraSmall Very small spacing, useful for minor gaps (8dp).
 * @property extraExtraSmall Small spacing, often used for compact elements (12dp).
 * @property extraSmall Slightly larger spacing for subtle separation (16dp).
 * @property small Small to medium spacing, commonly used for padding (20dp).
 * @property medium Standard spacing for elements that need a balanced gap (24dp).
 * @property large Larger spacing for comfortable separation (28dp).
 * @property extraLarge Extra spacing for distinct grouping (32dp).
 * @property extraExtraLarge Noticeably large spacing, useful for major sections (36dp).
 * @property extraExtraExtraLarge Very large spacing for clear separation (40dp).
 * @property huge Large gap used for significant spacing (44dp).
 * @property gigantic Very large gap for generous spacing (48dp).
 * @property extraExtraHuge Extra large spacing, great for distinct sections (52dp).
 * @property extraExtraExtraHuge Massive spacing for major layout sections (56dp).
 * @property extraExtraExtraExtraHuge The largest spacing for extreme separation (60dp).
 */
data class SizeDimensions(
    val default: Dp = 4.dp,
    val extraExtraExtraSmall: Dp = 8.dp,
    val extraExtraSmall: Dp = 12.dp,
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