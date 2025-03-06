package com.rahim.coach.feature.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.coach.feature.home.components.ActivityCard
import com.rahim.coach.feature.home.components.CustomOvalBottomShapeContainer
import com.rahim.coach.feature.home.components.FoodCardList
import com.rahim.coach.feature.home.components.HighlightItem
import com.rahim.coach.feature.home.components.HighlightsSection
import com.rahim.coach.feature.home.components.HomeConstants
import com.rahim.coach.feature.home.components.InteractiveArcCarousel
import com.rahim.coach.feature.home.components.PromoPager
import com.rahim.coach.feature.home.components.StripedTitle
import com.rahim.coach.library.designsystem.base.LocalSize
import com.rahim.coach.library.designsystem.base.LocalSpacing
import com.rahim.coach.library.designsystem.theme.CoachTheme
import kotlin.math.max


@Composable
internal fun HomeRoute() {
    HomeScreen()
}

@Composable
private fun HomeScreen() {

    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    val scrollState = rememberScrollState()
    val screenWidth by remember(configuration) { mutableIntStateOf(configuration.screenWidthDp) }
    val screenHeight by remember(configuration) { mutableIntStateOf(configuration.screenHeightDp) }
    val ovalHeight by remember(configuration) { mutableDoubleStateOf((max(screenHeight, screenWidth) * 0.55)) }

    val primaryArcCarouselItems = remember {
        mutableStateOf(HomeConstants.primaryArcCarouselItemsSample)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(state = scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Oval Header
        CustomOvalBottomShapeContainer(
            modifier = Modifier
                .fillMaxWidth()
                .height(ovalHeight.dp),
            backgroundColor = MaterialTheme.colorScheme.primary,
            ovalHeight = with(density) { (ovalHeight * 0.70f).dp.toPx() }
        ) {

            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InteractiveArcCarousel(
                    modifier = Modifier,
                    primaryItems = primaryArcCarouselItems.value,
                    cardItems = {
                        when (it) {
                            "Food" -> HomeConstants.arcCarouselCardFoodItemsSample
                            "Yoga" -> HomeConstants.arcCarouselCardFoodYogaSample
                            else -> HomeConstants.arcCarouselCardFoodDaySample
                        }
                    }
                )
            }
        }

        StripedTitle(
            text = "Highlights"
        )

        Spacer(
            modifier = Modifier
                .height(75.dp)
        )

        HighlightsSection(
            modifier = Modifier
                .width((screenWidth * 0.75f).dp)
                .height(130.dp),
            items = listOf(
                HighlightItem(R.drawable.ic_muscle, "exercises"),
                HighlightItem(
                    R.drawable.ic_measuring_tape,
                    "size",
                    isSelected = true
                ), // Just an example
                HighlightItem(R.drawable.ic_gym_report, "program"),
                HighlightItem(R.drawable.ic_earphone, "music"),
                HighlightItem(R.drawable.ic_boxing_glove, "exercise"),
                HighlightItem(R.drawable.ic_juice, "food"),
            )
        )

        Spacer(
            modifier = Modifier
                .height(75.dp)
        )

        PromoPager(
            slides = HomeConstants.demoPromoSlides,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .height(24.dp)
        )

        ActivityCard(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            icon = painterResource(R.drawable.img_daily_activity),
            title = "Daily activities",
            subtitle = "Daily activity: maximum 60 minutes per day",
            buttonIcon = painterResource(R.drawable.round_add_24),
            topRightContent = {
                Text(
                    text = "Calories 0",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                )
            }
        )

        Spacer(
            modifier = Modifier
                .height(24.dp)
        )

        ActivityCard(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            icon = painterResource(R.drawable.img_wheel_fortune),
            title = "Wheel of Fortune",
            subtitle = "Wheel of Fortune: Spin every day...",
            buttonIcon = painterResource(R.drawable.round_add_24),
            topRightContent = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "💎 +20",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    )
                }
            }
        )

        Spacer(
            modifier = Modifier
                .height(24.dp)
        )

        StripedTitle(
            text = "About Coach"
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = stringResource(com.rahim.coach.library.designsystem.R.string.coach_about),
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.Gray
            ),
            textAlign = TextAlign.Center
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
        )
        StripedTitle(
            text = "The most popular of the week"
        )
        Spacer(
            modifier = Modifier
                .height(24.dp)
        )

        FoodCardList(
            items = HomeConstants.demoFoodCardItems
        )

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    CoachTheme {
        HomeScreen()
    }
}


