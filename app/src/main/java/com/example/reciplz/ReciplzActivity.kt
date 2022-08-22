package com.example.reciplz

import com.example.reciplz.screens.main.MainScreen
import com.example.reciplz.screens.planner.PlannerScreen
import com.example.reciplz.screens.recipies.RecipiesScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.NavHostController
import com.example.reciplz.ui.theme.ReciplzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReciplzTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ReciplzApp()
                }
            }
        }
    }
}

@Composable
fun ReciplzApp() {
    ReciplzTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        NavHost(
            navController = navController,
            startDestination = "mainScreen"
        ) {
            composable(route = "mainScreen") {
                MainScreen(
                    onClickPlanner = {
                        navController.navigate("plannerScreen")
                    },
                    onClickRecipies = {
                        navController.navigate("recipiesScreen")
                    }
                )
            }
            composable(route = "plannerScreen") {
                PlannerScreen()
            }
            composable(route = "recipiesScreen") {
                RecipiesScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ReciplzApp()
}