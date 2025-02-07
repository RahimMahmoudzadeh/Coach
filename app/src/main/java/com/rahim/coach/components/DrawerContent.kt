package com.rahim.coach.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.R
import com.rahim.coach.MainActivity
import com.rahim.coach.library.designsystem.base.LocalSpacing
import com.rahim.coach.library.designsystem.theme.primaryColor
import timber.log.Timber

@SuppressLint("ContextCastToActivity")
@Composable
fun DrawerContent() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Image(modifier = Modifier.fillMaxWidth(), painter = painterResource(R.drawable.photo), contentDescription = null)
        Column(
            modifier = Modifier.padding(vertical = LocalSpacing.current.small)
                .verticalScroll(rememberScrollState())
        ) {
            val activity = LocalContext.current as MainActivity
            val isLogin = true // test
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
            )

            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = LocalSpacing.current.small,
                        vertical = LocalSpacing.current.large
                    )
                    .clickable {

                    }
                    .padding(
                        vertical = LocalSpacing.current.large
                    )
            ) {
                Text(
                    modifier = Modifier.padding(LocalSpacing.current.medium),
                    text = stringResource(R.string.exit),
                    style = MaterialTheme.typography.displaySmall,
                    fontSize = 16.sp
                )

                Icon(
                    modifier = Modifier
                        .padding(horizontal = LocalSpacing.current.small)
                        .width(22.dp)
                        .height(22.dp),
                    painter = painterResource(R.drawable.logout),
                    contentDescription = null,
                    tint = primaryColor
                )
            }
        }

    }
}

@Composable
fun DrawerItems(titles: List<String>, icons: List<Painter>, isLogin: Boolean) {
    val skipIndexes = setOf(3, 4, 5)
    val home = stringResource(R.string.home)
    titles.forEachIndexed { index, title ->
        if (isLogin.not() && index in skipIndexes) return@forEachIndexed
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    when(title){
                        home->{
                            // todo home
                        }
                    }
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
                    .padding(horizontal = LocalSpacing.current.small)
                    .width(22.dp)
                    .height(22.dp),
                painter = icons[index],
                contentDescription = null,
                tint = primaryColor
            )
        }
    }
}


@Preview
@Composable
fun Preview(){
    DrawerContent()
}