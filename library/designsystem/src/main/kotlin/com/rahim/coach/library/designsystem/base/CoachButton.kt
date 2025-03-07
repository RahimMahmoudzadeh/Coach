package com.rahim.coach.library.designsystem.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.rahim.coach.library.designsystem.theme.CaribbeanGreen
import com.rahim.coach.library.designsystem.theme.ThemeConstants

@Composable
fun CoachButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {

    val size = LocalSize.current
    val space = LocalSpacing.current
    val fontSize = LocalFontSize.current

    Button(
        onClick = onClick,
        shape = RoundedCornerShape(ThemeConstants.Dimensions.defaultCornerRadius),
        colors = ButtonDefaults.buttonColors
            (
            containerColor = CaribbeanGreen
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(size.extraExtraExtraHuge)
    ) {
        Text(
            text = title,
            fontSize = fontSize.small,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}