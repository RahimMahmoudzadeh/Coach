package com.rahim.coach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.rahim.coach.navigation.NavigationComponent
import com.rahim.coach.ui.theme.CoachTheme
import com.rahim.home.Home
import com.rahim.navigation.Destinations
import com.rahim.navigation.component.BottomNavigationBar

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
                        startDestination = Home
                    )
                }
            }
        }
    }
}
