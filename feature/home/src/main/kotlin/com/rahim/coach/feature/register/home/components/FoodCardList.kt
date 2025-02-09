package com.rahim.coach.feature.register.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.coach.feature.home.R

data class FoodCardItem(
    val imageRes: Int,
    val title: String,
    val subtitle: String,
    val time: String,
    val calories: String,
    val isFavorite: Boolean = false,
)

@Composable
fun FoodCard(
    item: FoodCardItem,
    onFavoriteClick: (Boolean) -> Unit,
    onAddClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = HomeConstants.DEF_CARD_ELEVATION),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        // We'll use a Box so we can draw custom corner accents behind the main content
        Box(
            modifier = Modifier
                .fillMaxSize()

        ) {
            // Draw top-left and bottom-right green corner strokes
            CornerAccent(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(14.dp),
                cornerColor = Color(0xFF00C853), // bright green
                cornerStrokeWidth = 2.dp
            )

            // The main Row: image on left, text in middle, plus button on the far right
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.Top
            ) {
                // Food image
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = "Food image",
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(12.dp))

                // Text content (title, subtitle, time/calories row)
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 12.dp), // So the text columns fill the remaining space
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = item.title,
                        style = TextStyle(
                            fontFamily = HomeConstants.HomeFont.inter,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp,
                            color = Color(0xFF333333)
                        )
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = item.subtitle,
                        style = TextStyle(
                            fontFamily = HomeConstants.HomeFont.inter,
                            fontWeight = FontWeight.Normal,
                            fontSize = 8.sp,
                            color = Color.LightGray
                        )
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    // Time + Calories in a row
                    Row {
                        Text(
                            text = item.time,
                            style = TextStyle(
                                fontFamily = HomeConstants.HomeFont.inter,
                                fontWeight = FontWeight.Normal,
                                fontSize = 10.sp,
                                color = Color.Gray
                            )
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = item.calories,
                            style = TextStyle(
                                fontFamily = HomeConstants.HomeFont.inter,
                                fontWeight = FontWeight.Normal,
                                fontSize = 10.sp,
                                color = Color.Gray
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.width(8.dp))


            }

            // Heart icon in top-right corner
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_heart
                ),
                contentDescription = "Favorite",
                tint = if (item.isFavorite) Color.Red else Color.Gray,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(10.dp)
                    .size(24.dp)
                    .clickable {
                        onFavoriteClick(!item.isFavorite)
                    }
            )

            // The round "plus" button
            Box(
                modifier = Modifier
                    .padding(10.dp)
                    .size(36.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFE0FFE9)) // pale green
                    .clickable { onAddClick() }
                    .align(Alignment.BottomEnd),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.round_add_24),
                    contentDescription = "Add to plan",
                    tint = Color(0xFF00C853),
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun CornerAccent(
    cornerColor: Color,
    cornerStrokeWidth: Dp,
    modifier: Modifier = Modifier,
) {
    Canvas(
        modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val strokePx = cornerStrokeWidth.toPx()
        val cornerRadius = 24.dp.toPx()  // how "curved" each corner arc is

        // Top-left arc
        drawArc(
            color = cornerColor,
            startAngle = 180f, // half circle to the left
            sweepAngle = 90f,  // 90° arc
            useCenter = false,
            style = Stroke(width = strokePx),
            topLeft = Offset(-cornerRadius / 2, -cornerRadius / 2),
            size = Size(cornerRadius, cornerRadius)
        )

        // Bottom-right arc
        drawArc(
            color = cornerColor,
            startAngle = 0f,
            sweepAngle = 90f,
            useCenter = false,
            style = Stroke(width = strokePx),
            topLeft = Offset(size.width - cornerRadius / 2, size.height - cornerRadius / 2),
            size = Size(cornerRadius, cornerRadius)
        )
    }
}

@Composable
fun FoodCardList(
    items: List<FoodCardItem>,
) {

    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
            .fillMaxSize()
            .background(Color.LightGray.copy(alpha = 0.1f)), // optional
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(16.dp))
        items.forEach { item ->
            FoodCard(
                item = item,
                onFavoriteClick = { newFavoriteValue ->
                    // handle toggling favorite
                },
                onAddClick = {
                    // handle add
                }
            )
            Spacer(Modifier.height(16.dp))
        }

    }
}