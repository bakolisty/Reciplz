package com.example.reciplz.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(
    onClickPlanner: () -> Unit = {},
    onClickRecipies: () -> Unit = {}
) {
    Column() {
        Text(text = "Main Screen")
        Button(onClick = onClickPlanner) {
            Text(text = "Planner")
        }
        Button(onClick = onClickRecipies) {
            Text(text = "Recipies")
        }
    }
}