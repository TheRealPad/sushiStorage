package com.example.mobile

import Pages
import SushiList
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile.ui.theme.MobileTheme
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.remember
import com.example.mobile.bottomBar.BottomBar
import com.example.mobile.data.SampleData
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mobile.creationPage.CreationPage
import com.example.mobile.favoritePage.Favorite
import com.example.mobile.ingredientList.IngredientListPage
import com.example.mobile.landingPage.Landing
import com.example.mobile.topBar.TopBar
import com.example.mobile.utils.FavoriteStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val context = LocalContext.current
    val store = FavoriteStore(context)
    val tokenText = store.getFavorites.collectAsState(initial = "")
    MobileTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val (selectedPage, setSelectedPage) = remember { mutableStateOf(Pages.Landing) }
            Scaffold(
                topBar = { TopBar()},
                bottomBar = { BottomBar(selectedPage, setSelectedPage) }
            ) { _ ->
                Column(modifier = Modifier.padding(bottom = 100.dp)) {
                    if (selectedPage == Pages.SushiList) SushiList(SampleData.sushiSample, store)
                    else if (selectedPage == Pages.Create) CreationPage()
                    else if (selectedPage == Pages.Favorites) Favorite(favorites = tokenText.value, store)
                    else if (selectedPage == Pages.IngredientList) IngredientListPage()
                    else Landing()
                }
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    locale = "en"
)
@Composable
fun PreviewSushiList() {
    App()
}