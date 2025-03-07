package com.rahim.coach.library.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import com.rahim.coach.library.designsystem.base.FontDimensions
import com.rahim.coach.library.designsystem.base.LocalFontSize
import com.rahim.coach.library.designsystem.base.LocalSize
import com.rahim.coach.library.designsystem.base.LocalSpacing
import com.rahim.coach.library.designsystem.base.SizeDimensions
import com.rahim.coach.library.designsystem.base.SpaceDimensions

private val DarkColorScheme = darkColorScheme(
    primary = CaribbeanGreen,
    onPrimary = MediumAquamarine,
    secondary = DarkSilver,
    onSecondary = OuterSpace,
    onSecondaryContainer = SilverChalice,
    primaryContainer = BodyColor,
    onPrimaryContainer = CharlestonGreen
)

private val LightColorScheme = lightColorScheme(
    primary = CaribbeanGreen,
    onPrimary = MediumAquamarine,
    secondary = DarkSilver,
    onSecondary = OuterSpace,
    primaryContainer = BodyColor,
    onSecondaryContainer = SilverChalice,
    onPrimaryContainer = CharlestonGreen
)

@Composable
fun CoachTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    CompositionLocalProvider(
        LocalSpacing provides SpaceDimensions(),
        LocalFontSize provides FontDimensions(),
        LocalSize provides SizeDimensions(),
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}