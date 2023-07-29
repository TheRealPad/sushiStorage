package com.example.mobile.bottomBar

import Pages
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
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.example.mobile.R

fun getWeight(selectedPage: Pages, page: Pages): Float {
    if (selectedPage == page)
        return 2f
    return 1f
}

fun getIconSize(selectedPage: Pages, page: Pages): Dp {
    if (selectedPage == page)
        return 70.dp
    return 20.dp
}

@Composable
fun BottomBar(selectedPage: Pages, changePage: (Pages) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.Gray),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(animateFloatAsState(getWeight(selectedPage, Pages.Landing)).value)
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) { changePage(Pages.Landing) }
                .align(Alignment.CenterVertically)
                .aspectRatio(1f)
                .background(Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.home), contentDescription = null, modifier = Modifier
                .size(getIconSize(selectedPage, Pages.Landing)))
        }
        Box(
            modifier = Modifier
                .weight(animateFloatAsState(getWeight(selectedPage, Pages.SushiList)).value)
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) { changePage(Pages.SushiList) }
                .align(Alignment.CenterVertically)
                .aspectRatio(1f)
                .background(Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.menu_book), contentDescription = null, modifier = Modifier
                .size(getIconSize(selectedPage, Pages.SushiList)))
        }
        Box(
            modifier = Modifier
                .weight(animateFloatAsState(getWeight(selectedPage, Pages.Create)).value)
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) { changePage(Pages.Create) }
                .align(Alignment.CenterVertically)
                .aspectRatio(1f)
                .background(Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.restaurant_menu), contentDescription = null, modifier = Modifier
                .size(getIconSize(selectedPage, Pages.Create)))
        }
        Box(
            modifier = Modifier
                .weight(animateFloatAsState(getWeight(selectedPage, Pages.Favorites)).value)
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) { changePage(Pages.Favorites) }
                .align(Alignment.CenterVertically)
                .aspectRatio(1f)
                .background(Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.favorite_selected), contentDescription = null, modifier = Modifier
                .size(getIconSize(selectedPage, Pages.Favorites)))
        }
        Box(
            modifier = Modifier
                .weight(animateFloatAsState(getWeight(selectedPage, Pages.IngredientList)).value)
                .fillMaxWidth()
                .clickable(
                    indication = null,
                    interactionSource = remember {
                        MutableInteractionSource()
                    }
                ) { changePage(Pages.IngredientList) }
                .align(Alignment.CenterVertically)
                .aspectRatio(1f)
                .background(Color.Gray, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(painter = painterResource(R.drawable.set_meal), contentDescription = null, modifier = Modifier
                .size(getIconSize(selectedPage, Pages.IngredientList)))
        }
    }
}