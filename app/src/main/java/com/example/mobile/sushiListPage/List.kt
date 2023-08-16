import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.mobile.dto.Sushi
import com.example.mobile.utils.FavoriteStore

@Composable
fun SushiList(sushis: List<Sushi>, store: FavoriteStore) {
    LazyColumn {
        items(sushis) { sushi ->
            SushiCard(sushi, store)
        }
    }
}
