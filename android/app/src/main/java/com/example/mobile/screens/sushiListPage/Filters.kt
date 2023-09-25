package com.example.mobile.screens.sushiListPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mobile.ui.theme.DarkGrey
import com.example.mobile.ui.theme.Grey

@Composable
fun Filters(displayFavoriteSushi: Boolean, setDisplayFavoriteSushi: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .padding(horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "FAVORITES", color = MaterialTheme.colors.primary)
        Switch(
            checked = displayFavoriteSushi,
            onCheckedChange = {
                setDisplayFavoriteSushi(it)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                checkedTrackColor = Color.Black,
                uncheckedThumbColor = DarkGrey,
                uncheckedTrackColor = Grey,
            )
        )
    }
}