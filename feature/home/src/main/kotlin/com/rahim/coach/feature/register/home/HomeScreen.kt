package com.rahim.coach.feature.register.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.coach.feature.home.R
import com.rahim.coach.feature.register.home.components.CustomOvalBottomShapeContainer
import com.rahim.coach.feature.register.home.components.FoodCardList
import com.rahim.coach.feature.register.home.components.ActivityCard
import com.rahim.coach.feature.register.home.components.HighlightItem
import com.rahim.coach.feature.register.home.components.HighlightsSection
import com.rahim.coach.feature.register.home.components.HomeConstants
import com.rahim.coach.feature.register.home.components.InteractiveArcCarousel
import com.rahim.coach.feature.register.home.components.PromoPager
import com.rahim.coach.feature.register.home.components.StripedTitle
import com.rahim.coach.library.designsystem.theme.CoachTheme
import kotlin.math.max


@Composable
internal fun HomeRoute() {
    HomeScreen()
}

@Composable
private fun HomeScreen() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp
    val scrollState = rememberScrollState()
    val ovalHeight = (max(screenHeight, screenWidth) * 0.73)

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
            backgroundColor = HomeConstants.HomeColors.CoachGreen
        ) {

            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    // App Icon - Middle Icon
                    Column(
                        modifier = Modifier
                            .align(Alignment.TopCenter),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(top = 20.dp)
                                .size(width = 72.dp, height = 87.dp),
                            imageVector = ImageVector.vectorResource(com.rahim.coach.library.designsystem.R.drawable.ic_app_icon),
                            contentDescription = "app logo",
                            tint = Color.White
                        )

                        Spacer(
                            modifier = Modifier
                                .height(8.dp)
                        )

                        Text(
                            text = "Your smart companion",
                            style = TextStyle(
                                fontFamily = HomeConstants.HomeFont.inter,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            ),
                            color = Color.White
                        )

                        Spacer(
                            modifier = Modifier
                                .height(8.dp)
                        )


                    }


                    // Menu and Settings
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = HomeConstants.HomeColors.BorderColor,
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(24.dp),
                                imageVector = ImageVector.vectorResource(R.drawable.menu),
                                contentDescription = "app logo",
                                tint = HomeConstants.HomeColors.IconColor
                            )
                        }



                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = HomeConstants.HomeColors.BorderColor,
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(24.dp),
                                imageVector = ImageVector.vectorResource(R.drawable.setting_2),
                                contentDescription = "app logo",
                                tint = HomeConstants.HomeColors.IconColor
                            )
                        }
                    }
                }


                Spacer(
                    modifier = Modifier
                        .height(60.dp)
                )
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
                HighlightItem(R.drawable.ic_measuring_tape, "size", isSelected = true), // Just an example
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
                        fontFamily = HomeConstants.HomeFont.inter,
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
                            fontFamily = HomeConstants.HomeFont.inter,
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
            text = stringResource(R.string.coach_about),
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


