package com.example.mobile.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun screenA() {
    Column() {
        Text("Tu", color = Color.White)
    }
}

@Composable
fun screenB() {
    Column() {
        Text("Es", color = Color.White)
    }
}

@Composable
fun screenC() {
    Column() {
        Text("Célibataire 🖕", color = Color.White)
    }
}