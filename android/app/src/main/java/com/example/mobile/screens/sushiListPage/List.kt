import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile.data.SampleData
import com.example.mobile.dto.Sushi
import com.example.mobile.screens.sushiListPage.Filters
import com.example.mobile.utils.FavoriteStore

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    locale = "en"
)
@Composable
fun PreviewSushiList() {
    SushiList(sushis = SampleData.sushiSample)
}

@Composable
fun SushiList(sushis: List<Sushi>) {
    val context = LocalContext.current
    val store = FavoriteStore(context)
    val tokenText = store.getFavorites.collectAsState(initial = "")
    val favoriteSushiId = tokenText.value.split(",")
    val favoriteSushi = SampleData.sushiSample.filter { sushi -> favoriteSushiId.any { p -> p == sushi.uuid.toString() } }
    var (displayFavorite, setDisplayFavorite) = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Filters(displayFavorite, setDisplayFavorite)
        LazyColumn(
            modifier = Modifier.padding(horizontal = 5.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            if (displayFavorite)
                items(favoriteSushi) { sushi ->
                    SushiCard(sushi, store)
                }
            else
                items(sushis) { sushi ->
                    SushiCard(sushi, store)
                }
        }
    }
}
