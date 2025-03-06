package com.rahim.coach.feature.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StripedTitle(
    text: String,
    color: Color = MaterialTheme.colorScheme.primary,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // Left stripes
        TripleStripes(color = color, isLeftToRight = false)

        Spacer(Modifier.width(12.dp))

        // The title text
        Text(
            text = text,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondary
            )
        )

        Spacer(Modifier.width(12.dp))

        // Right stripes
        TripleStripes(color = color, isLeftToRight = true)
    }
}

/**
 * Draws three stacked “angled stripes” of decreasing width, aligned at the right edge.
 */
@Composable
fun TripleStripes(
    color: Color,
    widestWidth: Dp = 30.dp,
    stripeHeight: Dp = 3.dp,
    widthStep: Dp = 10.dp,
    slant: Dp = 5.dp,
    isLeftToRight: Boolean,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        horizontalAlignment = if (isLeftToRight) Alignment.Start else Alignment.End
    ) {
        // Top stripe (widest)
        AngledStripe(
            color,
            width = widestWidth,
            height = stripeHeight,
            slant = slant,
            isLeftToRight
        )
        // Middle stripe
        AngledStripe(
            color,
            width = widestWidth - widthStep,
            height = stripeHeight,
            slant = slant,
            isLeftToRight
        )
        // Bottom stripe
        AngledStripe(
            color,
            width = widestWidth - widthStep * 2,
            height = stripeHeight,
            slant = slant,
            isLeftToRight
        )
    }
}

/**
 * A single “parallelogram” stripe: it’s basically a rectangle
 * shifted by [slant] at the bottom edge to create the angled effect.
 */
@Composable
fun AngledStripe(
    color: Color,
    width: Dp,
    height: Dp,
    slant: Dp,
    isLeftToRight: Boolean,
) {
    Canvas(
        modifier = Modifier
            .width(width)
            .height(height)
    ) {
        val path = Path().apply {
            if (isLeftToRight) {
                // top-left
                moveTo(0f, 0f)
                // top-right
                lineTo(size.width, 0f)
                // bottom-right
                lineTo(size.width - slant.toPx(), size.height)
                // bottom-left
                lineTo(0f, size.height)
                close()
            } else {
                // top-left
                moveTo(0f, 0f)
                // top-right
                lineTo(size.width, 0f)
                // bottom-right
                lineTo(size.width, size.height)
                // bottom-left
                lineTo(slant.toPx(), size.height)
                close()
            }
        }
        drawPath(path = path, color = color)
    }
}