package com.rahim.coach.feature.register.home

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.coach.feature.register.home.components.CustomOvalBottomShapeContainer
import com.rahim.coach.feature.register.home.components.HomeConstants
import com.rahim.coach.library.designsystem.R
import com.rahim.coach.library.designsystem.base.LocalFontSize
import com.rahim.coach.library.designsystem.base.LocalSize
import com.rahim.coach.library.designsystem.base.LocalSpacing
import com.rahim.coach.library.designsystem.theme.CaribbeanGreen
import com.rahim.coach.library.designsystem.theme.CoachTheme
import timber.log.Timber
import kotlin.math.max

sealed interface DrawerItemType {
    val title: Int
    val iconRes: Int

    data class Profile(
        @StringRes override val title: Int,
        @DrawableRes override val iconRes: Int,
    ) : DrawerItemType

    data class Message(
        @StringRes override val title: Int,
        @DrawableRes override val iconRes: Int,
    ) : DrawerItemType

    data class Language(
        @StringRes override val title: Int,
        @DrawableRes override val iconRes: Int,
    ) : DrawerItemType

    data class Support(
        @StringRes override val title: Int,
        @DrawableRes override val iconRes: Int,
    ) : DrawerItemType

    data class Notification(
        @StringRes override val title: Int,
        @DrawableRes override val iconRes: Int,
    ) : DrawerItemType

    data class Favorite(
        @StringRes override val title: Int,
        @DrawableRes override val iconRes: Int,
    ) : DrawerItemType

    data class Exist(
        @StringRes override val title: Int,
        @DrawableRes override val iconRes: Int,
    ) : DrawerItemType
}

@Composable
fun DrawerLayout(
    modifier: Modifier = Modifier,
    drawerState: DrawerState,
    content: @Composable () -> Unit,
) {
    ModalNavigationDrawer(
        modifier = modifier,
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = MaterialTheme.colorScheme.background,
                drawerContentColor = MaterialTheme.colorScheme.onSurface,
                windowInsets = WindowInsets(0),
            ) {
                DrawerContent()
            }
        }, content = content
    )
}

val listOfDrawerItems = listOf(
    DrawerItemType.Profile(R.string.profile, R.drawable.user),
    DrawerItemType.Message(R.string.message, R.drawable.messagetext),
    DrawerItemType.Language(R.string.language, R.drawable.languagesquare),
    DrawerItemType.Support(R.string.support, R.drawable.headphone),
    DrawerItemType.Notification(R.string.notification, R.drawable.notificationbing),
    DrawerItemType.Favorite(R.string.favorite, R.drawable.heart),
    DrawerItemType.Exist(R.string.exit, R.drawable.logout),
)

@SuppressLint("ContextCastToActivity")
@Composable
fun DrawerContent(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val space = LocalSpacing.current
    val size = LocalSize.current
    val fontSize = LocalFontSize.current

    val screenWidth by remember { mutableIntStateOf(configuration.screenWidthDp) }
    val screenHeight by remember { mutableIntStateOf(configuration.screenHeightDp) }
    val ovalHeight by remember { mutableDoubleStateOf((max(screenHeight, screenWidth) / 2.7)) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CustomOvalBottomShapeContainer(
            modifier = Modifier
                .fillMaxWidth()
                .height(ovalHeight.dp),
            backgroundColor = HomeConstants.HomeColors.CoachGreen,
            x1 = 2f, y1 = 1.3f, x2 = 0f, y2 = 2f
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = space.extraExtraLarge),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.path1),
                    contentDescription = "app icon",
                    modifier = Modifier.size(83.dp)
                )
                Text(
                    text = stringResource(R.string.your_smart_phone),
                    color = Color.White,
                    modifier = Modifier.padding(top = space.extraSmall)
                )
                Text(
                    text = stringResource(R.string.every_practice_step_towards_success),
                    color = Color.White,
                )
            }
        }
        listOfDrawerItems.forEach { drawerItem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        when (drawerItem) {
                            is DrawerItemType.Profile -> {

                            }

                            is DrawerItemType.Exist -> TODO()
                            is DrawerItemType.Favorite -> TODO()
                            is DrawerItemType.Language -> TODO()
                            is DrawerItemType.Message -> TODO()
                            is DrawerItemType.Notification -> TODO()
                            is DrawerItemType.Support -> TODO()
                        }
                    }
                    .padding(
                        start = LocalSpacing.current.small,
                        bottom = LocalSpacing.current.extraExtraLarge
                    )
                    .then(
                        if (drawerItem is DrawerItemType.Exist) {
                            Modifier.padding(top = space.gigantic)
                        } else {
                            Modifier
                        }
                    ),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = LocalSpacing.current.medium),
                    text = stringResource(drawerItem.title),
                    style = MaterialTheme.typography.displaySmall,
                    fontSize = fontSize.small
                )
                Icon(
                    modifier = Modifier
                        .padding(horizontal = LocalSpacing.current.small)
                        .size(size.small),
                    painter = painterResource(drawerItem.iconRes),
                    contentDescription = null,
                    tint = CaribbeanGreen
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewDrawerContent() {
    CoachTheme {
        DrawerContent()
    }
}