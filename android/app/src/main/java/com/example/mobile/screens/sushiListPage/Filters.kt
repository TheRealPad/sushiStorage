package com.example.mobile.screens.sushiListPage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mobile.R
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
        Text(text = stringResource(id = R.string.display_favorite_sushi), color = MaterialTheme.colors.primary, fontWeight = FontWeight.Bold)
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