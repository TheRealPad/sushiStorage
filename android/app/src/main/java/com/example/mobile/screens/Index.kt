package com.example.mobile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun screenA() {
    Column() {
        Text("How to cook", color = MaterialTheme.colors.primary)
    }
}

@Composable
fun screenC() {
    Column() {
        Text("Map", color = MaterialTheme.colors.primary)
    }
}