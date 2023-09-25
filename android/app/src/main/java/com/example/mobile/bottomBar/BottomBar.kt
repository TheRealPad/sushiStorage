package com.example.mobile.bottomBar

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile.R
import com.example.mobile.ui.theme.DarkGrey
import com.example.mobile.ui.theme.Grey
import com.example.mobile.ui.theme.MobileTheme

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewBottomBar() {
    val (indexDisplay, setIndexDisplay) = remember { mutableStateOf(3) }
    MobileTheme {
        Surface {
            BottomBar(indexDisplay, setIndexDisplay)
        }
    }
}


@Composable
fun BottomBar(numberPage: Int, setIndexDisplay: (Int) -> Unit) {
    val iconList = listOf<Int>(R.drawable.chef_hat, R.drawable.sushi_button, R.drawable.map_button)
    val interactionSource = remember { MutableInteractionSource() }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clip(shape = RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
            .background(Grey, shape = MaterialTheme.shapes.large),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier
                .padding(vertical = 5.dp)
                .clip(shape = CircleShape)
                .background(DarkGrey)
                .width(100.dp)
                .height(5.dp))
            Row(modifier =Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                repeat(numberPage) { index ->
                    Box(
                        modifier = Modifier
                            .background(Color.Transparent)
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null,
                                onClick = { setIndexDisplay(index) })
                            .size(100.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Image(
                            modifier = Modifier
                                .background(Color.Transparent)
                                .size(50.dp),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(id = iconList[index]),
                            contentDescription = "icon"
                        )
                    }
                }
            }
        }
    }
}