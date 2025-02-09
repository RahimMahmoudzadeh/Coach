package com.rahim.coach.feature.register.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class HighlightItem(
    val icon: Int,
    val label: String,
    val isSelected: Boolean = false,
)

@Composable
fun ActivityCard(
    modifier: Modifier = Modifier,
    icon: Painter,
    title: String,
    subtitle: String,
    topRightContent: @Composable (RowScope.() -> Unit)? = null,
    middleContent: @Composable (RowScope.() -> Unit)? = null,
    buttonIcon: Painter,
    onButtonClick: () -> Unit = {},
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        // You can tweak elevation or card colors as needed
        elevation = CardDefaults.cardElevation(defaultElevation = HomeConstants.DEF_CARD_ELEVATION),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            topRightContent?.let {
                Row(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopEnd),
                    verticalAlignment = Alignment.CenterVertically,
                    content = it
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                // -- Top Row: leading icon, title, optional top-right content
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = icon,
                        contentDescription = null,
                        tint = Color.Unspecified, // If your icon is colored already
                        modifier = Modifier.size(40.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = title,
                        style = TextStyle(
                            fontFamily = HomeConstants.HomeFont.inter,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = Color(0xFF333333)
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))


                }

                // -- Divider (thin gray line)
                Spacer(Modifier.height(8.dp))

                middleContent?.let {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        content = it
                    )
                }

                Spacer(Modifier.height(8.dp))
                HorizontalDivider(thickness = 1.dp, color = Color.LightGray.copy(alpha = 0.7f))
                Spacer(Modifier.height(8.dp))

                // -- Bottom Row: subtitle on left, round button on right
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = subtitle,
                        style = TextStyle(
                            fontFamily = HomeConstants.HomeFont.inter,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF00C853)) // bright green
                            .clickable { onButtonClick() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = buttonIcon,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}