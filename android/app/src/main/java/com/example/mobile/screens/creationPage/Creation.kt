package com.example.mobile.screens.creationPage

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile.R

@Composable
fun CreationPage() {
    Text(text = stringResource(R.string.title_creation_page))
}

@Preview
@Composable
fun PreviewCreationPage() {
    CreationPage()
}