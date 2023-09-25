package com.example.mobile.screens.tutoPage

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobile.ui.theme.MobileTheme
import com.example.mobile.R
import com.example.mobile.ui.theme.Black
import com.example.mobile.ui.theme.Red

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    locale = "en"
)
@Composable
fun PreviewTuto() {
    MobileTheme {
        Tuto()
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode",
    locale = "en"
)
@Composable
fun PreviewButtonDescription() {
    MobileTheme {
        ButtonDescription("Sushi", MaterialTheme.colors.onSurface)
    }
}

@Composable
fun ButtonDescription(title: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .padding(horizontal = 15.dp, vertical = 10.dp)
    ) {
        Text(
            text = title,
            color = MaterialTheme.colors.secondary,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun RedirectButtonTop() {
    val imageList = listOf(R.drawable.rice_background, R.drawable.fish_background)
    val buttonsTitleList =  listOf(R.string.how_to_cook_rice, R.string.how_to_cook_fish)
    val buttonsColorList =  listOf(Red, Black)

    Row(
        modifier = Modifier
            .absolutePadding(bottom = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(2) { index ->
            Box(
                modifier = Modifier
                    .size(180.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .paint(
                        painterResource(id = imageList[index]),
                        contentScale = ContentScale.Fit
                    ),
                contentAlignment = Alignment.BottomEnd
            ) {
                Box(
                    modifier = Modifier
                        .padding(10.dp)
                ) {
                    ButtonDescription(
                        title = stringResource(id = buttonsTitleList[index]),
                        backgroundColor = buttonsColorList[index]
                    )
                }
            }
        }
    }
}

@Composable
fun RedirectButtonBottom() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .clip(RoundedCornerShape(10.dp))
            .paint(
                painterResource(id = R.drawable.sushi_background),
                contentScale = ContentScale.FillWidth
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
        ) {
            ButtonDescription(
                title = stringResource(id = R.string.how_to_cook_sushi),
                backgroundColor = Black
            )
        }
    }
}

@Composable
fun TopPage() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RedirectButtonTop()
        RedirectButtonBottom()
    }
}

@Composable
fun BottomPage() {
    Box(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.sushi_cook),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(300.dp)
        )
    }
}

@Composable
fun Tuto() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .absolutePadding(top = 50.dp)
            .background(MaterialTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopPage()
        BottomPage()
    }
}