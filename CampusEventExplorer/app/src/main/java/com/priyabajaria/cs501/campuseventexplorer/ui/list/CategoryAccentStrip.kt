package com.priyabajaria.cs501.campuseventexplorer.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/** Thin vertical colour bar down the left edge of a card, tinted by category. */
@Composable
fun CategoryAccentStrip(color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier
            .width(6.dp)
            .fillMaxHeight()
            .background(color)
    )
}