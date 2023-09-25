import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.example.mobile.data.SampleData
import com.example.mobile.dto.Sushi
import com.example.mobile.screens.sushiListPage.Filters
import com.example.mobile.utils.FavoriteStore

@Composable
fun SushiList(sushis: List<Sushi>) {
    val context = LocalContext.current
    val store = FavoriteStore(context)
    val tokenText = store.getFavorites.collectAsState(initial = "")
    val favoriteSushiId = tokenText.value.split(",")
    val favoriteSushi = SampleData.sushiSample.filter { sushi -> favoriteSushiId.any { p -> p == sushi.uuid.toString() } }
    var (displayFavorite, setDisplayFavorite) = remember { mutableStateOf(false) }

    Column {
        Filters(displayFavorite, setDisplayFavorite)
        LazyColumn {
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
