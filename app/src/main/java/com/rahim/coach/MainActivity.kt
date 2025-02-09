package com.rahim.coach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.rahim.coach.library.designsystem.theme.CoachTheme
import com.rahim.coach.library.navigation.Destinations
import com.rahim.coach.library.navigation.component.BottomNavigationBar
import com.rahim.coach.navigation.NavigationComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            CoachTheme {
                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    BottomNavigationBar(
                        navController = navController,
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
