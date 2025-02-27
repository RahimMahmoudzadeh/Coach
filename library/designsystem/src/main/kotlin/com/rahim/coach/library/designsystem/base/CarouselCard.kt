package com.rahim.coach.library.designsystem.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.coach.library.designsystem.R
import com.rahim.coach.library.designsystem.theme.ThemeConstants

@Composable
fun CarouselCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    duration: String,
    onAddClick: () -> Unit,
    onCardClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .size(
                width = 160.dp,
                height = 250.dp
            )
            .clickable { onCardClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = ThemeConstants.DEF_CARD_ELEVATION)
    ) {
        Column {
            // Image Section
            Image(
                painter = painterResource(R.drawable.food),
                contentDescription = "Card Image",
                modifier = Modifier
                    .padding(2.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Text Section
            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontFamily = ThemeConstants.CoachFont.inter,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = ThemeConstants.Colors.TitleColor
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    style = TextStyle(
                        fontFamily = ThemeConstants.CoachFont.inter,
                        fontWeight = FontWeight.Normal,
                        fontSize = 8.sp,
                        color = ThemeConstants.Colors.LabelColor
                    )
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Bottom Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Duration Icon and Text
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = "Duration Icon",
                        tint = Color.Gray,
                        modifier = Modifier.size(18.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    Text(
                        text = duration,
                        style = TextStyle(
                            fontFamily = ThemeConstants.CoachFont.inter,
                            fontWeight = FontWeight.Normal,
                            fontSize = 8.sp,
                            color = Color.Gray
                        )
                    )
                }

                // Add Button
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .background(
                            color = Color(0xFFD0FCEA),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(2.dp)
                        .clickable { onAddClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.round_add_24),
                        contentDescription = "Add Icon",
                        tint = ThemeConstants.Colors.CoachGreen,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}