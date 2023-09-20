package com.example.mobile.screens.favoritePage

import SushiCard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile.R
import com.example.mobile.data.SampleData
import com.example.mobile.utils.FavoriteStore

@Composable
fun Favorite(favorites: String, store: FavoriteStore) {
    val favoriteSushi = favorites.split(",")
    val sushis = SampleData.sushiSample.filter { sushi -> favoriteSushi.any { p -> p == sushi.uuid.toString() } }
    Column() {
        Text(text = stringResource(R.string.landing_page))
        LazyColumn {
            items(sushis) { sushi ->
                SushiCard(sushi, store)
            }
        }
    }
}

@Preview
@Composable
fun PreviewFavoritePage() {
    Box(modifier = Modifier.background(MaterialTheme.colors.primary)) {
        Favorite(favorites = "Maguro nigiri sushi", FavoriteStore(LocalContext.current))
    }
}