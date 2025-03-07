package com.rahim.coach.feature.home.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.rahim.coach.library.designsystem.base.LocalFontSize
import com.rahim.coach.library.designsystem.base.LocalSize
import com.rahim.coach.library.designsystem.base.LocalSpacing
import com.rahim.coach.library.designsystem.theme.AeroBlue
import com.rahim.coach.library.designsystem.theme.CaribbeanGreen
import com.rahim.coach.library.designsystem.theme.OuterSpace
import com.rahim.coach.library.designsystem.theme.SilverChalice
import com.rahim.coach.library.designsystem.theme.font_bold
import com.rahim.coach.library.designsystem.theme.font_medium
import kotlinx.coroutines.launch
import kotlin.math.abs
import kotlin.math.absoluteValue
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.roundToInt
import kotlin.math.sin

@Composable
fun InteractiveArcCarousel(
    modifier: Modifier = Modifier,
    primaryItems: List<String>,
    cardItems: (String) -> List<String>,
) {

    val size = LocalSize.current
    val fontSize = LocalFontSize.current

    var primaryItem by remember { mutableStateOf(primaryItems.first()) }
    var secondaryItems by remember { mutableStateOf(cardItems(primaryItem)) }


    val sweepAngle = primaryItems.size * 18f

    val middleIndex = primaryItems.size / 2
    val initialAngleOffset = -45f  // Start at the top of the arc
    val angleStep = remember { sweepAngle / (primaryItems.size - 1) }

    // Track the scroll/drag angle
    val currentAngle = remember { Animatable(initialAngleOffset) }
    val scope = rememberCoroutineScope()

    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        val arcSize = maxWidth

        Canvas(
            modifier = Modifier
                .size(arcSize)
        ) {
            drawCircle(
                brush = Brush.verticalGradient(
                    0f to Color.White.copy(alpha = 0.6f),
                    0.2f to Color.White.copy(alpha = 0.1f),
                    0.4f to Color.White.copy(alpha = 0f),
                    1f to Color.White.copy(alpha = 0f)
                ),
                center = center,
                style = Stroke(width = size.default.toPx(), cap = StrokeCap.Round)
            )

            drawCircle(
                color = Color.White,
                radius = 15f,
                center = Offset(center.x, 0f),
                style = Stroke(width = 3f)
            )

            drawCircle(
                color = Color.White,
                radius = 11f,
                center = Offset(center.x, 0f),
                style = Fill
            )
        }


        for (index in primaryItems.indices) {

            val targetAngle =
                currentAngle.value + angleStep * (index - middleIndex) - sweepAngle / 2
            val angleInRadians = Math.toRadians(targetAngle.toDouble())
            val radiusX = maxWidth.value / 1.8f
            val radiusY = maxHeight.value / 1.8f
            val radius = min(radiusX, radiusY)
            val x = radius * cos(angleInRadians).toFloat()
            val y = radius * sin(angleInRadians).toFloat()
            val tangentAngle = targetAngle + 90f

            // Compute a fade effect based on angular distance from -90 degrees.
            val angularDistance = abs(targetAngle + 90f) % 360f
            val fadeFactor = (1f - (angularDistance / 180f)).coerceIn(0f, 1f)

            LaunchedEffect(Unit) {
                val closestIndex =
                    ((currentAngle.value + 90) / angleStep).roundToInt()
                        .coerceIn(0, primaryItems.size - 1)
                primaryItem = primaryItems[primaryItems.size - 1 - closestIndex]
                secondaryItems = cardItems(primaryItem)
            }

            Text(
                primaryItems[index],
                fontSize = fontSize.small,
                color = Color.White,
                modifier = Modifier
                    .offset(x.dp, y.dp)
                    .graphicsLayer {
                        rotationZ = tangentAngle
                        alpha = fadeFactor
                    }
                    .pointerInput(Unit) {
                        detectDragGestures(
                            onDragEnd = {
                                val closestIndex =
                                    ((currentAngle.value + 90) / angleStep).roundToInt()
                                        .coerceIn(0, primaryItems.size - 1)
                                val tAngle = closestIndex * angleStep - 90
                                primaryItem = primaryItems[primaryItems.size - 1 - closestIndex]
                                secondaryItems = cardItems(primaryItem)
                                scope.launch {
                                    // Animate to snap to the target angle
                                    currentAngle.animateTo(tAngle, animationSpec = tween(400))
                                }
                            },
                            onDrag = { change, dragAmount ->
                                scope.launch {
                                    val dragX = dragAmount.x
                                    currentAngle.snapTo(currentAngle.value + dragX * 0.2f)
                                }
                            }
                        )
                    }

            )
        }
        val pagerState = rememberPagerState { secondaryItems.size }

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = (maxWidth / 2f) - 80.dp),
            pageSpacing = 10.dp,
            modifier = Modifier
                .width(maxWidth)
                .fillMaxHeight()
                .padding(top = 62.dp)
        ) { index ->
            val safeIndex = index.coerceAtMost(secondaryItems.size - 1)
            val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
            val normalizedOffset = pageOffset.absoluteValue.coerceIn(0f, 1f)

            val translation = lerp(0f, 100f, 1f - normalizedOffset)

            AnimatedContent(
                targetState = secondaryItems[safeIndex],
                transitionSpec = {
                    (fadeIn(
                        animationSpec = tween(500, delayMillis = 90)
                    ) + scaleIn(
                        initialScale = 0.92f,
                        animationSpec = tween(220, delayMillis = 90)
                    ))
                        .togetherWith(fadeOut(animationSpec = tween(200)))

                }
            ) {
                CarouselCard(
                    modifier = Modifier
                        .graphicsLayer {
                            translationY = translation
                        },
                    title = it,
                    description = "Continuous exercises to improve...",
                    duration = "20 min",
                    onAddClick = {

                    },
                    onCardClick = {

                    }
                )
            }

        }
    }
}

@Composable
fun CarouselCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    duration: String,
    onAddClick: () -> Unit,
    onCardClick: () -> Unit,
) {
    val size = LocalSize.current
    val space = LocalSpacing.current
    val fontSize = LocalFontSize.current

    Card(
        modifier = modifier
            .size(
                width = 160.dp,
                height = 250.dp
            )
            .clickable { onCardClick() },
        shape = RoundedCornerShape(size.extraSmall),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = HomeConstants.DEF_CARD_ELEVATION)
    ) {
        Column {
            // Image Section
            Image(
                painter = painterResource(com.rahim.coach.library.designsystem.R.drawable.food),
                contentDescription = "Card Image",
                modifier = Modifier
                    .padding(space.hairline)
                    .clip(RoundedCornerShape(size.extraSmall))
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(size.extraExtraExtraSmall))

            // Text Section
            Column(
                modifier = Modifier
                    .padding(horizontal = space.small)
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontFamily = font_bold,
                        fontWeight = FontWeight.Bold,
                        fontSize = fontSize.default,
                        color = OuterSpace
                    )
                )
                Spacer(modifier = Modifier.height(size.default))
                Text(
                    text = description,
                    style = TextStyle(
                        fontFamily = font_medium,
                        fontWeight = FontWeight.Normal,
                        fontSize = fontSize.extraExtraSmall,
                        color = SilverChalice
                    )
                )
            }

            Spacer(modifier = Modifier.height(size.extraExtraSmall))

            // Bottom Section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = space.extraSmall),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Duration Icon and Text
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = com.rahim.coach.library.designsystem.R.drawable.ic_clock),
                        contentDescription = "Duration Icon",
                        tint = Color.Gray,
                        modifier = Modifier.size(size.small)
                    )

                    Spacer(modifier = Modifier.width(size.default))

                    Text(
                        text = duration,
                        style = TextStyle(
                            fontFamily = font_medium,
                            fontWeight = FontWeight.Normal,
                            fontSize = fontSize.extraExtraSmall,
                            color = Color.Gray
                        )
                    )
                }

                // Add Button
                Box(
                    modifier = Modifier
                        .size(size.large)
                        .background(
                            color = AeroBlue,
                            shape = RoundedCornerShape(size.extraExtraSmall)
                        )
                        .padding(space.extraSmall)
                        .clickable { onAddClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = com.rahim.coach.library.designsystem.R.drawable.round_add_24),
                        contentDescription = "Add Icon",
                        tint = CaribbeanGreen,
                        modifier = Modifier.size(size.extraSmall)
                    )
                }
            }

            Spacer(modifier = Modifier.height(size.extraExtraExtraSmall))
        }
    }
}