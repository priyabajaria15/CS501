package com.priyabajaria.cs501.campuseventexplorer.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.background
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.categoryPalette

/** Small coloured pill showing an event's category. */
@Composable
fun CategoryChip(category: String, modifier: Modifier = Modifier) {
    val palette = categoryPalette(category)
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = palette.container,
        contentColor = palette.onContainer
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Box(
                Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(palette.accent)
            )
            Text(
                text = category.uppercase(),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}