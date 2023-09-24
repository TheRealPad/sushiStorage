package com.example.mobile.screens.scrollPage
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.example.mobile.utils.findClosestIndex
import com.example.mobile.utils.generateScreenPositions
import kotlinx.coroutines.launch

@Composable
fun ScrollPage(screenList: List<@Composable () -> Unit>, indexDisplay: Int, setIndexDisplay: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(1000.dp)
            .fillMaxHeight()
    ) {
        ScrollBoxes(screenList, indexDisplay, setIndexDisplay)
    }
}

@Composable
private fun ScrollBoxes(screenList: List<@Composable () -> Unit>, indexDisplay: Int, setIndexDisplay: (Int) -> Unit) {
    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current.density
    val screenWidth = (configuration.screenWidthDp * density).toInt()
    val screenPositions = generateScreenPositions(screenList.size, screenWidth)
    val currentIndexDisplay by rememberUpdatedState(indexDisplay)
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(scrollState)
    ) {
        repeat(screenList.size) { index ->
            val boxModifier = Modifier
                .background(Color(0, 0, index * 100))
                .width(configuration.screenWidthDp.dp)
                .fillMaxHeight()

            Box(
                modifier = boxModifier,
                contentAlignment = Alignment.Center
            ) {
                screenList[index].invoke()
            }
        }
    }
    LaunchedEffect(Unit) {
        scrollState.animateScrollTo(screenPositions[indexDisplay])
    }
    LaunchedEffect(scrollState.isScrollInProgress) {
        if (!scrollState.isScrollInProgress) {
            val index = findClosestIndex(scrollState.value, screenPositions)
            /*setIndexDisplay(index)*/
            scope.launch { scrollState.animateScrollTo(screenPositions[index]) }
        }
    }
    DisposableEffect(currentIndexDisplay) {
        onDispose {
            scope.launch { scrollState.animateScrollTo(screenPositions[currentIndexDisplay]) }
        }
    }
}