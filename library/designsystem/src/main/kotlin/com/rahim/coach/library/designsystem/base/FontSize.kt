package com.rahim.coach.library.designsystem.base

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Defines a set of standard font size dimensions for consistent typography.
 *
 * @property extraExtraSmall Very small font size, used for minor labels or captions (8sp).
 * @property default Small font size, typically used for secondary text (12sp).
 * @property small Slightly larger font size for compact readability (16sp).
 * @property medium Standard font size, commonly used for body text (18sp).
 * @property large Larger font size for emphasis or headers (20sp).
 * @property extraLarge Extra large font size for subheadings or distinct elements (24sp).
 * @property huge Very large font size for major headings (32sp).
 * @property gigantic Extremely large font size for standout text (40sp).
 */
data class FontDimensions(
    val extraExtraSmall: TextUnit = 8.sp,
    val default: TextUnit = 12.sp,
    val small: TextUnit = 16.sp,
    val medium: TextUnit = 18.sp,
    val large: TextUnit = 20.sp,
    val extraLarge: TextUnit = 24.sp,
    val huge: TextUnit = 32.sp,
    val gigantic: TextUnit = 40.sp,
)

val LocalFontSize = compositionLocalOf { FontDimensions() }