package com.rahim.coach.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.coach.library.designsystem.base.LocalFontSize
import com.rahim.coach.library.designsystem.base.LocalSize
import com.rahim.coach.library.designsystem.base.LocalSpacing
import com.rahim.coach.library.designsystem.theme.font_bold
import com.rahim.coach.library.designsystem.theme.font_medium

@Composable
fun PromoCard(
    slide: PromoSlide,
    modifier: Modifier = Modifier,
) {

    val size = LocalSize.current
    val space = LocalSpacing.current
    val fontSize = LocalFontSize.current

    Box(
        contentAlignment = Alignment.Center
    ) {


        Box(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(space.medium))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(slide.backgroundColor, slide.secondaryColor)
                    )
                )

        ) {

            // 2) Text layout
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = space.medium, end = 80.dp)
                    .height(120.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = slide.smallTitle,
                    fontFamily = font_medium,
                    fontSize = fontSize.default,
                    color = Color.White,
                    fontWeight = FontWeight.Normal,
                )
                Spacer(modifier = Modifier.height(space.default))
                Text(
                    text = slide.bigTitle,
                    fontFamily = font_bold,
                    fontSize = fontSize.large,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
            }


        }

        // 3) Main image, clipped to a circle or large corner shape
        Image(
            painter = painterResource(id = slide.imageRes),
            contentDescription = "Promo image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(130.dp)
                .rotate(45f)
                .align(Alignment.CenterEnd)
                .clip(RoundedCornerShape(size.medium))

        )
    }

}

@Composable
fun PromoPager(
    slides: List<PromoSlide>,
    modifier: Modifier = Modifier,
) {

    val size = LocalSize.current
    val space = LocalSpacing.current
    val fontSize = LocalFontSize.current

    val pagerState = rememberPagerState(initialPage = 0) {
        slides.size
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = space.extraLarge),
            pageSpacing = space.extraLarge,
            modifier = Modifier
                .fillMaxWidth()  // adjust as needed
        ) { pageIndex ->
            val slide = slides[pageIndex]
            PromoCard(slide = slide)
        }

        Spacer(modifier = Modifier.height(space.medium))

        // A simple dot indicator
        Row(
            modifier = Modifier
                .padding(12.dp),
            horizontalArrangement = Arrangement.spacedBy(space.extraSmall)
        ) {
            repeat(slides.size) { index ->
                val isSelected = pagerState.currentPage == index
                val size = if (isSelected) space.medium else space.extraSmall
                val color = if (isSelected) Color.White else Color.LightGray

                Box(
                    modifier = Modifier
                        .size(width = size, height = space.extraSmall)
                        .clip(CircleShape)
                        .background(color)
                )
            }
        }
    }
}

data class PromoSlide(
    val backgroundColor: Color,         // main color or gradient start
    val secondaryColor: Color,          // optional gradient end color
    val imageRes: Int,                  // the main large image
    val smallTitle: String,             // e.g. "Today is a different..."
    val bigTitle: String,               // e.g. "Special finger..."
)
