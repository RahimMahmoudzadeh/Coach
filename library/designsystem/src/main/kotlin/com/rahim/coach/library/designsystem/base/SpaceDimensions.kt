package com.rahim.coach.library.designsystem.base

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Defines a set of standard spacing dimensions for consistent layout spacing.
 *
 * @property hairline The thinnest spacing, used for fine adjustments (2dp).
 * @property default The smallest standard spacing, often used for subtle gaps (4dp).
 * @property extraSmall Small spacing, useful for minor separations (8dp).
 * @property small Slightly larger spacing for compact layouts (12dp).
 * @property smallMedium A middle ground between small and medium spacing (14dp).
 * @property medium Standard spacing for balanced separation (16dp).
 * @property large Larger spacing for comfortable gaps (20dp).
 * @property extraLarge Extra spacing for distinct grouping (24dp).
 * @property extraExtraLarge Very large spacing for major sections (28dp).
 * @property extraExtraExtraLarge Extremely large spacing for clear separation (32dp).
 * @property huge Large gap for significant spacing (36dp).
 * @property gigantic Massive spacing for generous layout sections (40dp).
 */
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