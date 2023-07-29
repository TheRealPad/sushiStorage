import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile.R
import com.example.mobile.dto.Sushi
import com.example.mobile.ui.theme.MobileTheme
import com.example.mobile.utils.FavoriteStore

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewSushiCard() {
    MobileTheme {
        Surface {
            SushiCard(
                sushi = Sushi("Colleague", "Hey, take a look at Jetpack Compose, it's great!", R.drawable.icon_sushi),
                FavoriteStore(LocalContext.current)
            )
        }
    }
}

@Composable
fun SushiList(messages: List<Sushi>, store: FavoriteStore) {
    LazyColumn {
        items(messages) { message ->
            SushiCard(message, store)
        }
    }
}
