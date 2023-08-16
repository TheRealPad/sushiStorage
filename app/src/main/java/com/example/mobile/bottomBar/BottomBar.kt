package com.example.mobile.bottomBar

import Pages
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile.R
import com.example.mobile.ui.theme.MobileTheme

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewBottomBar() {
    val (selectedPage, setSelectedPage) = remember { mutableStateOf(Pages.Landing) }
    MobileTheme {
        Surface {
            BottomBar(selectedPage, changePage = setSelectedPage)
        }
    }
}

@Composable
fun getIconBackgroundColor(isSelected: Boolean): Color {
    if (isSelected)
        return Color.White
    return MaterialTheme.colors.primary
}

@Composable
fun BottomBar(selectedPage: Pages, changePage: (Pages) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(MaterialTheme.colors.primary, shape = MaterialTheme.shapes.large),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .weight(animateFloatAsState(0.5f).value)
                .fillMaxHeight()
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) { changePage(Pages.Landing) }
                .align(Alignment.CenterVertically)
                .padding(1.dp)
                .background(getIconBackgroundColor(isSelected = selectedPage ===Pages.Landing), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.home), contentDescription = null, modifier = Modifier
                .size(40.dp))
        }
        Box(
            modifier = Modifier
                .weight(animateFloatAsState(0.5f).value)
                .fillMaxHeight()
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) { changePage(Pages.SushiList) }
                .align(Alignment.CenterVertically)
                .padding(1.dp)
                .background(getIconBackgroundColor(isSelected = selectedPage ===Pages.SushiList), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.menu_book), contentDescription = null, modifier = Modifier
                .size(40.dp))
        }
        Box(
            modifier = Modifier
                .weight(animateFloatAsState(0.5f).value)
                .fillMaxHeight()
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) { changePage(Pages.Create) }
                .align(Alignment.CenterVertically)
                .padding(1.dp)
                .background(getIconBackgroundColor(isSelected = selectedPage ===Pages.Create), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.restaurant_menu), contentDescription = null, modifier = Modifier
                .size(40.dp))
        }
        Box(
            modifier = Modifier
                .weight(animateFloatAsState(0.5f).value)
                .fillMaxHeight()
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) { changePage(Pages.Favorites) }
                .align(Alignment.CenterVertically)
                .padding(1.dp)
                .background(getIconBackgroundColor(isSelected = selectedPage ===Pages.Favorites), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.favorite_selected), contentDescription = null, modifier = Modifier
                .size(40.dp))
        }
        Box(
            modifier = Modifier
                .weight(animateFloatAsState(0.5f).value)
                .fillMaxHeight()
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) { changePage(Pages.IngredientList) }
                .align(Alignment.CenterVertically)
                .padding(1.dp)
                .background(getIconBackgroundColor(isSelected = selectedPage ===Pages.IngredientList), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.set_meal), contentDescription = null, modifier = Modifier
                .size(40.dp))
        }
    }
}