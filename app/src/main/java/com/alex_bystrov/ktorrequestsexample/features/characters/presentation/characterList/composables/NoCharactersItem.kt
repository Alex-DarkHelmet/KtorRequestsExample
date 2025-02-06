package com.alex_bystrov.ktorrequestsexample.features.characters.presentation.characterList.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alex_bystrov.ktorrequestsexample.R

@Composable
fun NoCharacterItem(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(300.dp).fillMaxSize(),
        alignment = Alignment.Center,
        painter = painterResource(id = R.drawable.baseline_sentiment_very_dissatisfied_24),
        contentDescription = "No items",
    )
}