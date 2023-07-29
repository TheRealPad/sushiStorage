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
            val context = LocalContext.current
            val store = FavoriteStore(context)
            val tokenText = store.getFavorites.collectAsState(initial = "")
            MobileTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SushiList(SampleData.conversationSample, store)
                }
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewSushiList() {
    val context = LocalContext.current
    val store = FavoriteStore(context)
    val tokenText = store.getFavorites.collectAsState(initial = "")

    MobileTheme {
        val (selectedPage, setSelectedPage) = remember { mutableStateOf(Pages.Landing) }
        Scaffold(
            topBar = { TopBar()},
            bottomBar = { BottomBar(selectedPage, setSelectedPage) }
        ) { padding ->
            Column(modifier = Modifier.padding(bottom = 100.dp)) {
                if (selectedPage == Pages.SushiList) SushiList(SampleData.conversationSample, store)
                else if (selectedPage == Pages.Create) Text(text = "La page création est affichée")
                else if (selectedPage == Pages.Favorites) {
                    Text(text = stringResource(R.string.landing_page))
                    Text(text = "Les données stockée : ${tokenText.value}")
                }
                else if (selectedPage == Pages.IngredientList) Text(text = "La page liste d'ingrédients est affichée")
                else Landing()
            }
        }
    }
}