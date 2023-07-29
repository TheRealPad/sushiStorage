package com.example.mobile.landingPage
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile.R
import com.example.mobile.ui.theme.MobileTheme

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewLanding() {
    MobileTheme {
        Surface {
            Landing()
        }
    }
}

@Composable
fun Title(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.subtitle2,
        color = MaterialTheme.colors.primary,
        fontSize = 30.sp
    )
}

@Composable
fun Description(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.subtitle2,
        color = MaterialTheme.colors.onSecondary,
    )
}

@Composable
fun Landing() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.background)
    ) {
        Description(text = stringResource(R.string.sushi_story_intro))
        Title(text = stringResource(R.string.sushi_origin))
        Description(text = stringResource(R.string.sushi_origin_description))
        Title(text = stringResource(R.string.sushi_today_title))
        Description(text = stringResource(R.string.sushi_today_content))
    }
}