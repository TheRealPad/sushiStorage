package com.example.mobile

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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.mobile.screens.screenA
import com.example.mobile.screens.screenB
import com.example.mobile.screens.screenC
import com.example.mobile.screens.scrollPage.ScrollPage
import com.example.mobile.topBar.TopBar
import com.example.mobile.utils.FavoriteStore

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
    val screenList: List<@Composable () -> Unit> = listOf({ screenA() }, { screenB() }, { screenC() })
    MobileTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val (indexDisplay, setIndexDisplay) = remember { mutableStateOf(0) }
            Scaffold(
                topBar = { TopBar()},
                bottomBar = { BottomBar(screenList.size, setIndexDisplay) }
            ) { padding ->
                Column(modifier = Modifier.padding(bottom = 70.dp)) {
                    ScrollPage(screenList, indexDisplay, setIndexDisplay)
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