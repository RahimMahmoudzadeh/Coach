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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rahim.coach.feature.home.R
import com.rahim.coach.feature.home.DrawerLayout
import com.rahim.coach.library.designsystem.base.LocalFontSize
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
            val fontSize = LocalFontSize.current

            CoachTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                ) {
                    DrawerLayout(drawerState = drawerState) {
                        Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(color = MaterialTheme.colorScheme.primary)
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
                                            .padding(top = space.large)
                                            .size(width = 72.dp, height = 87.dp),
                                        imageVector = ImageVector.vectorResource(com.rahim.coach.library.designsystem.R.drawable.ic_app_icon),
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
                                                shape = RoundedCornerShape(size.extraExtraSmall)
                                            )
                                            .border(
                                                width = 1.dp,
                                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                                shape = RoundedCornerShape(size.extraExtraSmall)
                                            )
                                            .padding(space.extraSmall).clickable(onClick = {
                                                coroutineScope.launch { drawerState.open() }
                                            }),
                                        imageVector = ImageVector.vectorResource(com.rahim.coach.library.designsystem.R.drawable.menu),
                                        contentDescription = "app logo",
                                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                    Icon(
                                        modifier = Modifier
                                            .size(size.extraExtraExtraLarge)
                                            .background(
                                                color = Color.White,
                                                shape = RoundedCornerShape(size.extraExtraSmall)
                                            )
                                            .border(
                                                width = 1.dp,
                                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                                shape = RoundedCornerShape(size.extraExtraSmall)
                                            )
                                            .padding(space.extraSmall),
                                        imageVector = ImageVector.vectorResource(com.rahim.coach.library.designsystem.R.drawable.setting_2),
                                        contentDescription = "app logo",
                                        tint = MaterialTheme.colorScheme.onPrimaryContainer
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
}
