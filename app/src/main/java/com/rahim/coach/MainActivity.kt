package com.rahim.coach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rahim.coach.feature.home.R
import com.rahim.coach.feature.register.home.DrawerLayout
import com.rahim.coach.feature.register.home.components.HomeConstants
import com.rahim.coach.library.designsystem.base.LocalSize
import com.rahim.coach.library.designsystem.base.LocalSpacing
import com.rahim.coach.library.designsystem.theme.CoachTheme
import com.rahim.coach.library.navigation.Destinations
import com.rahim.coach.library.navigation.component.BottomNavigationBar
import com.rahim.coach.navigation.NavigationComponent
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val coroutineScope = rememberCoroutineScope()

            val size = LocalSize.current
            val space = LocalSpacing.current

            CoachTheme {
                DrawerLayout(drawerState = drawerState) {
                    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = HomeConstants.HomeColors.CoachGreen)
                                .padding(top = space.extraExtraExtraLarge)
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

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(size.medium),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Icon(
                                    modifier = Modifier
                                        .size(size.extraExtraExtraLarge)
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(size.default)
                                        )
                                        .border(
                                            width = 1.dp,
                                            color = HomeConstants.HomeColors.BorderColor,
                                            shape = RoundedCornerShape(size.default)
                                        )
                                        .padding(space.extraSmall).clickable(onClick = {
                                            coroutineScope.launch { drawerState.open() }
                                        }),
                                    imageVector = ImageVector.vectorResource(R.drawable.menu),
                                    contentDescription = "app logo",
                                    tint = HomeConstants.HomeColors.IconColor
                                )
                                Icon(
                                    modifier = Modifier
                                        .size(size.extraExtraExtraLarge)
                                        .background(
                                            color = Color.White,
                                            shape = RoundedCornerShape(size.default)
                                        )
                                        .border(
                                            width = 1.dp,
                                            color = HomeConstants.HomeColors.BorderColor,
                                            shape = RoundedCornerShape(size.default)
                                        )
                                        .padding(space.extraSmall),
                                    imageVector = ImageVector.vectorResource(R.drawable.setting_2),
                                    contentDescription = "app logo",
                                    tint = HomeConstants.HomeColors.IconColor
                                )
                            }
                        }
                    }, bottomBar = {
                        BottomNavigationBar(
                            navController = navController,
                            navBackStackEntry = navBackStackEntry
                        )
                    }) { innerPadding ->
                        NavigationComponent(
                            innerPadding = innerPadding,
                            navController = navController,
                            startDestination = Destinations.Home
                        )
                    }
                }
            }
        }
    }
}
