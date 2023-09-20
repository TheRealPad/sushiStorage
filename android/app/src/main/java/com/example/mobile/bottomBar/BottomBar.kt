package com.example.mobile.bottomBar

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
    val (indexDisplay, setIndexDisplay) = remember { mutableStateOf(0) }
    MobileTheme {
        Surface {
            BottomBar(indexDisplay, setIndexDisplay)
        }
    }
}

@Composable
fun BottomBar(numberPage: Int, setIndexDisplay: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(MaterialTheme.colors.primary, shape = MaterialTheme.shapes.large),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        repeat(numberPage) { index ->
            Button(onClick = { setIndexDisplay(index) }) {
                Text(text = "$index")
            }
        }
    }
}