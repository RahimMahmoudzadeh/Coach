package com.platform.mediacenter.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.R
import com.rahim.coach.MainActivity
import com.rahim.coach.ui.theme.LocalSpacing
import com.rahim.coach.ui.theme.primaryColor
import timber.log.Timber

@SuppressLint("ContextCastToActivity")
@Composable
fun DrawerContent() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.8f)
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(primaryColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(70.dp)
                    .height(70.dp),
                tint = Color.White,
                painter = painterResource(R.drawable.path1),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(top = 10.dp),
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                text = stringResource(R.string.label),
                color = Color.White
            )
            Text(
                modifier = Modifier.padding(top = 10.dp),
                style = MaterialTheme.typography.displaySmall,
                text = stringResource(R.string.label2),
                color = Color.White
            )


        }
        Box {
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            ) {
                val width = size.width
                val height = size.height

                drawArc(
                    color = primaryColor,
                    startAngle = 0f,
                    sweepAngle = 180f,
                    useCenter = true,
                    topLeft = Offset(0f, height),
                    size = Size(width, height)
                )
            }
        }


        Column(
            modifier = Modifier.padding(vertical = LocalSpacing.current.semiMedium)
        ) {
            val activity = LocalContext.current as MainActivity
            val isLogin = false
            DrawerItems(
                listOf(
                    stringResource(R.string.home),
                    stringResource(R.string.profile),
                    stringResource(R.string.message),
                    stringResource(R.string.language),
                    stringResource(R.string.support),
                    stringResource(R.string.notification),
                    stringResource(R.string.favorite),
//                    if (isLogin) stringResource(R.string.exit) else stringResource(R.string.login_register),
                ),
                listOf(
                    painterResource(R.drawable.home),
                    painterResource(R.drawable.user),
                    painterResource(R.drawable.messagetext),
                    painterResource(R.drawable.languagesquare),
                    painterResource(R.drawable.headphone),
                    painterResource(R.drawable.notificationbing),
                    painterResource(R.drawable.heart),
                ),
                isLogin
            ) {
//                navController.navigate(Screen.Detail.route)
            }
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        )

        Row(
            horizontalArrangement = Arrangement.End, modifier = Modifier
                .fillMaxWidth()
                .clickable {

                }
                .padding(
                    horizontal = LocalSpacing.current.small,
                    vertical = LocalSpacing.current.semiMedium
                )
        ) {
            Text(
                modifier = Modifier.padding(horizontal = LocalSpacing.current.medium),
                text = "خروج",
                style = MaterialTheme.typography.displaySmall,
                fontSize = 16.sp
            )

            Icon(
                modifier = Modifier
                    .padding(horizontal = LocalSpacing.current.semiMedium)
                    .width(22.dp)
                    .height(22.dp),
                painter = painterResource(R.drawable.logout),
                contentDescription = null,
                tint = primaryColor
            )
        }
    }
}

@Composable
fun DrawerItems(titles: List<String>, icons: List<Painter>, isLogin: Boolean, onClick: () -> Unit) {
    val skipIndexes = setOf(3, 4, 5, 6)
    titles.forEachIndexed { index, title ->
//        if (isLogin.not() && index in skipIndexes) return@forEachIndexed
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick()
                    Timber.tag("4718").e("DrawerContent: Click")
                }
                .padding(
                    horizontal = LocalSpacing.current.small,
                    vertical = LocalSpacing.current.medium
                ),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(horizontal = LocalSpacing.current.medium),
                text = title,
                style = MaterialTheme.typography.displaySmall,
                fontSize = 16.sp
            )
            Icon(
                modifier = Modifier
                    .padding(horizontal = LocalSpacing.current.semiMedium)
                    .width(22.dp)
                    .height(22.dp),
                painter = icons[index],
                contentDescription = null,
                tint = primaryColor
            )
        }
    }
}