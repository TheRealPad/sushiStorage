import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile.R
import com.example.mobile.dto.Sushi
import com.example.mobile.ui.theme.DarkGrey
import com.example.mobile.ui.theme.LightGrey
import com.example.mobile.ui.theme.MobileTheme
import com.example.mobile.ui.theme.Red
import com.example.mobile.utils.FavoriteStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

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
                sushi = Sushi(UUID.randomUUID(),"Pad", "Le sushi de pad", R.drawable.icon_sushi),
                FavoriteStore(LocalContext.current)
            )
        }
    }
}

@Composable
fun SushiCard(sushi: Sushi, store: FavoriteStore) {
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = LightGrey)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .background(color = LightGrey)
        ) {
            SushiIcon(icon = sushi.iconId)
            Spacer(modifier = Modifier.width(8.dp))
            SushiData(name = sushi.name, description = sushi.description)
            FavoriteSushi(sushi.uuid.toString(), store)
        }
    }
}

@Composable
fun SushiIcon(icon: Int) {
    Image(
        painter = painterResource(icon),
        contentDescription = null,
        modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(10.dp))
            .border(1.5.dp, MaterialTheme.colors.onSurface, RoundedCornerShape(10.dp)),
        contentScale = ContentScale.FillHeight
    )
}

fun setFavoriteSushi(name: String, store: FavoriteStore) {
    CoroutineScope(Dispatchers.IO).launch {
        store.saveFavorites(name)
    }
}

@Composable
fun FavoriteSushi(uuid: String, store: FavoriteStore) {
    val list = store.getFavorites.collectAsState(initial = "")
    var isFavorite by remember { mutableStateOf(list.value.contains(uuid)) }
    val iconFavorite = if (isFavorite) R.drawable.favorite_selected else R.drawable.favorite_unselected

    isFavorite = list.value.contains(uuid)
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier
            .clickable(
                indication = null,
                interactionSource = remember {
                    MutableInteractionSource()
                }
            ) {
                if (isFavorite) {
                    setFavoriteSushi(list.value.replace("$uuid,", ""), store)
                } else {
                    setFavoriteSushi(list.value + "$uuid,", store)
                }
                isFavorite = !isFavorite
            }
            .align(Alignment.CenterEnd)) {
            Image(painter = painterResource(iconFavorite), contentDescription = null, modifier = Modifier
                .width(40.dp)
                .height(40.dp))
        }
    }
}


@Composable
fun SushiData(name: String, description: String) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .widthIn(200.dp, 200.dp)) {
        Text(
            text = name,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Surface(
            shape = MaterialTheme.shapes.medium,
            elevation = 1.dp,
            color = MaterialTheme.colors.surface,
            modifier = Modifier
                .animateContentSize()
                .padding(1.dp)
                .width(400.dp)
                .clickable { isExpanded = !isExpanded }
        ) {
            Text(
                text = description,
                modifier = Modifier.padding(all = 4.dp),
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
        }
    }
}