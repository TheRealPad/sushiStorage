package com.example.mobile.ingredientList

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobile.R

@Composable
fun IngredientListPage() {
    Text(text = stringResource(R.string.title_ingredient_list))
}

@Preview
@Composable
fun PreviewIngredientList() {
    IngredientListPage()
}