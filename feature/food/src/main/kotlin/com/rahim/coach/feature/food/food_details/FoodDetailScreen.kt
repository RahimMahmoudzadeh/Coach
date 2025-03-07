package com.rahim.coach.feature.food.food_details

import CustomOvalBottomShapeContainer
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
import com.rahim.coach.library.designsystem.R
import com.rahim.coach.library.designsystem.base.CarouselCard
import com.rahim.coach.library.designsystem.base.CoachButton
import com.rahim.coach.library.designsystem.base.LocalFontSize
import com.rahim.coach.library.designsystem.base.LocalSize
import com.rahim.coach.library.designsystem.base.LocalSpacing
import com.rahim.coach.library.designsystem.base.StripedTitle
import com.rahim.coach.library.designsystem.theme.CaribbeanGreen
import com.rahim.coach.library.designsystem.theme.CharlestonGreen
import com.rahim.coach.library.designsystem.theme.CoachTheme
import com.rahim.coach.library.designsystem.theme.DarkSilver
import com.rahim.coach.library.designsystem.theme.OuterSpace
import com.rahim.coach.library.designsystem.theme.Quartz
import com.rahim.coach.library.designsystem.theme.SilverChalice
import com.rahim.coach.library.designsystem.theme.font_bold
import com.rahim.coach.library.designsystem.theme.font_medium
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

    val size = LocalSize.current
    val space = LocalSpacing.current
    val fontSize = LocalFontSize.current

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
            backgroundColor = CaribbeanGreen
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
                                .padding(top = space.large)
                                .size(width = 72.dp, height = 87.dp),
                            imageVector = ImageVector.vectorResource(R.drawable.ic_app_icon),
                            contentDescription = "app logo",
                            tint = Color.White
                        )

                        Spacer(
                            modifier = Modifier
                                .height(space.extraSmall)
                        )

                        Text(
                            text = "Your smart companion",
                            style = TextStyle(
                                fontFamily = font_bold,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = fontSize.small
                            ),
                            color = Color.White
                        )

                        Spacer(
                            modifier = Modifier
                                .height(space.extraSmall)
                        )


                    }


                    // Menu and Settings
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(space.extraLarge),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Box(
                            modifier = Modifier
                                .size(size.extraExtraExtraLarge)
                                .background(
                                    color = Color.Transparent,
                                    shape = RoundedCornerShape(size.extraExtraSmall)
                                )
                                .border(
                                    width = 1.dp,
                                    color = Color.White,
                                    shape = RoundedCornerShape(size.extraExtraSmall)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(size.extraExtraExtraLarge),
                                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                                contentDescription = "back button",
                                tint = Color.White
                            )
                        }



                        Box(
                            modifier = Modifier
                                .size(size.extraExtraExtraLarge)
                                .background(
                                    color = Color.White,
                                    shape = RoundedCornerShape(size.extraExtraSmall)
                                )
                                .border(
                                    width = 1.dp,
                                    color = SilverChalice,
                                    shape = RoundedCornerShape(size.extraExtraSmall)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(size.medium),
                                imageVector = ImageVector.vectorResource(R.drawable.setting_2),
                                contentDescription = "settings button",
                                tint = CharlestonGreen
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
                        topEnd = size.medium,
                        topStart = size.medium,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
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
                                .padding(horizontal = space.extraLarge),
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
                                        .size(size.medium),
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(size.extraExtraExtraSmall)
                                )
                                Text(
                                    text = "75% (User satisfaction)",
                                    style = TextStyle(
                                        fontFamily = font_medium,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = fontSize.small,
                                        color = Quartz
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
                                        .size(size.medium),
                                )
                                Spacer(
                                    modifier = Modifier
                                        .width(size.extraExtraExtraSmall)
                                )
                                Text(
                                    text = "4.5/5",
                                    style = TextStyle(
                                        fontFamily = font_medium,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = fontSize.small,
                                        color = Quartz
                                    )
                                )

                            }
                        }

                        Spacer(
                            modifier = Modifier
                                .height(size.extraLarge)
                        )

                        Column(
                            modifier = Modifier
                                .padding(horizontal = space.extraLarge),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Spicy noodles",
                                style = TextStyle(
                                    fontFamily = font_bold,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = fontSize.medium,
                                    color = OuterSpace
                                )
                            )

                            Spacer(
                                modifier = Modifier
                                    .height(size.extraSmall)
                            )

                            Text(
                                text = stringResource(com.rahim.coach.library.designsystem.R.string.food_detail_test_body),
                                style = TextStyle(
                                    fontFamily = font_medium,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = fontSize.default,
                                    color = DarkSilver
                                )
                            )
                        }

                        Spacer(
                            modifier = Modifier
                                .height(size.medium)
                        )

                        FoodDetailTabs(
                            modifier = Modifier
                                .padding(horizontal = space.extraLarge),
                        )
                        Spacer(
                            modifier = Modifier
                                .height(size.medium)
                        )
                        CoachButton(
                            modifier = Modifier
                                .padding(horizontal = space.extraLarge),
                            title = "Add"
                        ) { }
                        Spacer(
                            modifier = Modifier
                                .height(size.medium)
                        )

                        StripedTitle(
                            modifier = Modifier
                                .padding(horizontal = space.extraLarge),
                            text = "Related items",
                        )
                        Spacer(
                            modifier = Modifier
                                .height(size.medium)
                        )

                        LazyRow(
                            contentPadding = PaddingValues(horizontal = space.extraLarge),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(space.medium),
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
                                .height(size.medium)
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
                            .padding(space.medium),
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

    val size = LocalSize.current
    val space = LocalSpacing.current
    val fontSize = LocalFontSize.current

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
                    color = CaribbeanGreen
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
                            fontSize = fontSize.default,
                            color = if (selectedTabIndex == index) OuterSpace else Quartz
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
    val fontSize = LocalFontSize.current
    val space = LocalSpacing.current

    Text(
        text = "Nutritional information goes here",
        style = TextStyle(
            fontFamily = font_medium,
            fontWeight = FontWeight.Normal,
            fontSize = fontSize.default,
            color = DarkSilver
        ),
        modifier = Modifier.padding(space.medium)
    )
}

@Composable
fun RecipeContent() {
    val fontSize = LocalFontSize.current
    val space = LocalSpacing.current
    val size = LocalSize.current

    Column(modifier = Modifier.padding(space.medium)) {
        Text(
            text = "1. Cooking the noodles: Boil the noodles in salted water, then drain and rinse with cold water.",
            style = TextStyle(
                fontFamily = font_medium,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize.default,
                color = DarkSilver
            )
        )
        Spacer(modifier = Modifier.height(space.extraSmall))
        Text(
            text = "2. Sautéing: Sauté the vegetables in a little oil until they are soft.",
            style = TextStyle(
                fontFamily = font_medium,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize.default,
                color = DarkSilver
            )
        )
        Spacer(modifier = Modifier.height(size.extraExtraExtraSmall))
        Text(
            text = "3. Combining: Add the noodles and sauces (such as soy sauce or tomato sauce) to the vegetables and season with spices.",
            style = TextStyle(
                fontFamily = font_medium,
                fontWeight = FontWeight.Normal,
                fontSize = fontSize.default,
                color = DarkSilver
            )
        )
    }
}


@Composable
fun IngredientsContent() {

    val fontSize = LocalFontSize.current
    val space = LocalSpacing.current

    Text(
        text = "List of ingredients goes here",
        style = TextStyle(
            fontFamily = font_medium,
            fontWeight = FontWeight.Normal,
            fontSize = fontSize.default,
            color = DarkSilver
        ),
        modifier = Modifier.padding(space.medium)
    )
}


@Preview
@Composable
fun FoodDetailScreenPreview() {
    CoachTheme {
        FoodDetailScreen()
    }
}
