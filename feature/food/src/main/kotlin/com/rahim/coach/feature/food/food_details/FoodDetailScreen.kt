package com.rahim.coach.feature.food.food_details

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseInOutExpo
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.coach.library.designsystem.R
import com.rahim.coach.library.designsystem.base.CarouselCard
import com.rahim.coach.library.designsystem.base.CoachButton
import com.rahim.coach.library.designsystem.theme.CoachTheme
import com.rahim.coach.library.designsystem.theme.ThemeConstants
import kotlinx.coroutines.delay
import kotlin.math.max

@Composable
internal fun FoodDetailRoute() {
    FoodDetailScreen()
}

@Composable
private fun FoodDetailScreen(
    modifier: Modifier = Modifier,
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp
    val scrollState = rememberScrollState()
    val ovalHeight = (max(screenHeight, screenWidth) * 0.9)

    var isMainCardVisible by remember { mutableStateOf(false) }
    var isFoodImageRotated by remember { mutableStateOf(false) }

    // Animation State
    val animatedRotation by animateFloatAsState(
        targetValue = if (isFoodImageRotated) 0f else 360f,
        animationSpec = tween(durationMillis = 800, easing = EaseInOutExpo),
        label = "RotationAnimation"
    )

    LaunchedEffect(Unit) {
        delay(300) // Delay to create a natural effect
        isMainCardVisible = true
        isFoodImageRotated = true
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(state = scrollState),
        contentAlignment = Alignment.TopCenter
    ) {

        // Oval Header
        CustomOvalBottomShapeContainer(
            modifier = Modifier
                .fillMaxWidth()
                .height(ovalHeight.dp),
            backgroundColor = ThemeConstants.Colors.CoachGreen
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
                            imageVector = ImageVector.vectorResource(R.drawable.ic_app_icon),
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
                                fontFamily = ThemeConstants.CoachFont.inter,
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
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(ThemeConstants.Dimensions.defaultCornerRadius)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(ThemeConstants.Dimensions.defaultCornerRadius)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(40.dp),
                                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                                contentDescription = "back button",
                                tint = Color.White
                            )
                        }



                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(ThemeConstants.Dimensions.defaultCornerRadius)
                                )
                                .border(
                                    width = 1.dp,
                                    color = ThemeConstants.Colors.BorderColor,
                                    shape = RoundedCornerShape(ThemeConstants.Dimensions.defaultCornerRadius)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(24.dp),
                                imageVector = ImageVector.vectorResource(R.drawable.setting_2),
                                contentDescription = "settings button",
                                tint = ThemeConstants.Colors.IconColor
                            )
                        }
                    }
                }
            }
        }

        AnimatedVisibility(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            visible = isMainCardVisible,
            enter = slideInVertically(
                initialOffsetY = { it }, // Start from below the screen
                animationSpec = tween(durationMillis = 600)
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 280.dp),
                contentAlignment = Alignment.TopCenter
            ) {


                Surface(
                    shape = RoundedCornerShape(
                        topEnd = 24.dp,
                        topStart = 24.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0f.dp
                    ),
                    color = Color.White,
                ) {

                    Column(
                        modifier = Modifier
                            .padding(top = 180.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_food_user_satisfaction),
                                    contentDescription = "user satisfaction icon",
                                    modifier = Modifier
                                        .size(24.dp),
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(8.dp)
                                )
                                Text(
                                    text = "75% (User satisfaction)",
                                    style = TextStyle(
                                        fontFamily = ThemeConstants.CoachFont.inter,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 16.sp,
                                        color = ThemeConstants.Colors.LabelColor
                                    )
                                )

                            }


                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_food_user_rating),
                                    contentDescription = "user satisfaction icon",
                                    modifier = Modifier
                                        .size(24.dp),
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(8.dp)
                                )
                                Text(
                                    text = "4.5/5",
                                    style = TextStyle(
                                        fontFamily = ThemeConstants.CoachFont.inter,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 16.sp,
                                        color = ThemeConstants.Colors.LabelColor
                                    )
                                )

                            }
                        }

                        Spacer(
                            modifier = Modifier
                                .height(32.dp)
                        )

                        Column(
                            modifier = Modifier
                                .padding(horizontal = 24.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Spicy noodles",
                                style = TextStyle(
                                    fontFamily = ThemeConstants.CoachFont.inter,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 18.sp,
                                    color = ThemeConstants.Colors.TitleColor
                                )
                            )

                            Spacer(
                                modifier = Modifier
                                    .height(16.dp)
                            )

                            Text(
                                text = stringResource(R.string.food_detail_test_body),
                                style = TextStyle(
                                    fontFamily = ThemeConstants.CoachFont.inter,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 13.sp,
                                    color = ThemeConstants.Colors.BodyColor
                                )
                            )
                        }

                        Spacer(
                            modifier = Modifier
                                .height(24.dp)
                        )

                        FoodDetailTabs(
                            modifier = Modifier
                                .padding(horizontal = 24.dp),
                        )
                        Spacer(
                            modifier = Modifier
                                .height(24.dp)
                        )
                        CoachButton(
                            modifier = Modifier
                                .padding(horizontal = 24.dp),
                            title = "Add"
                        ) { }
                        Spacer(
                            modifier = Modifier
                                .height(24.dp)
                        )

                        StripedTitle(
                            modifier = Modifier
                                .padding(horizontal = 24.dp),
                            text = "Related items",
                        )
                        Spacer(
                            modifier = Modifier
                                .height(24.dp)
                        )

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = 24.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                        ) {
                            items(
                                count = 5
                            ) { index ->
                                CarouselCard(
                                    title = "$index Macaroni and cheese",
                                    description = "$index Barbecue chicken, mushroom...",
                                    duration = "20",
                                    onAddClick = {},
                                    onCardClick = {}
                                )
                            }
                        }

                        Spacer(
                            modifier = Modifier
                                .height(24.dp)
                        )
                    }

                }

                Box(
                    modifier = Modifier
                        .graphicsLayer {
                            translationY = -200f
                            rotationZ = animatedRotation
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_food_detail_container),
                        contentDescription = "Card Image",
                        modifier = Modifier
                            .size(225.dp),
                        contentScale = ContentScale.Fit
                    )
                    Image(
                        painter = painterResource(R.drawable.img_food_detail_test),
                        contentDescription = "Card Image",
                        modifier = Modifier
                            .size(225.dp)
                            .padding(16.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }


    }
}


@Composable
fun FoodDetailTabs(
    modifier: Modifier = Modifier
) {
    var selectedTabIndex by remember { mutableStateOf(1) } // Default to "Recipe"

    val tabTitles = listOf("Nutritional value", "Recipe", "Ingredients")

    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .height(3.dp),
                    color = ThemeConstants.Colors.CoachGreen
                )
            },
            divider = {}
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            text = title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = if (selectedTabIndex == index) ThemeConstants.Colors.TitleColor else ThemeConstants.Colors.LabelColor
                        )
                    }
                )
            }
        }

        // Tab Content
        when (selectedTabIndex) {
            0 -> NutritionalValueContent()
            1 -> RecipeContent()
            2 -> IngredientsContent()
        }
    }
}


@Composable
fun NutritionalValueContent() {
    Text(
        text = "Nutritional information goes here",
        style = TextStyle(
            fontFamily = ThemeConstants.CoachFont.inter,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            color = ThemeConstants.Colors.BodyColor
        ),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun RecipeContent() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "1. Cooking the noodles: Boil the noodles in salted water, then drain and rinse with cold water.",
            style = TextStyle(
                fontFamily = ThemeConstants.CoachFont.inter,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = ThemeConstants.Colors.BodyColor
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "2. Sautéing: Sauté the vegetables in a little oil until they are soft.",
            style = TextStyle(
                fontFamily = ThemeConstants.CoachFont.inter,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = ThemeConstants.Colors.BodyColor
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "3. Combining: Add the noodles and sauces (such as soy sauce or tomato sauce) to the vegetables and season with spices.",
            style = TextStyle(
                fontFamily = ThemeConstants.CoachFont.inter,
                fontWeight = FontWeight.Normal,
                fontSize = 13.sp,
                color = ThemeConstants.Colors.BodyColor
            )
        )
    }
}


@Composable
fun IngredientsContent() {
    Text(
        text = "List of ingredients goes here",
        style = TextStyle(
            fontFamily = ThemeConstants.CoachFont.inter,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            color = ThemeConstants.Colors.BodyColor
        ),
        modifier = Modifier.padding(16.dp)
    )
}


@Preview
@Composable
fun FoodDetailScreenPreview() {
    CoachTheme {
        FoodDetailScreen()
    }
}
