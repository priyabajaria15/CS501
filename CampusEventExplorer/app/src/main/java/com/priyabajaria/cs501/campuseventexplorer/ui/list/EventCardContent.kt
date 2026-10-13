package com.priyabajaria.cs501.campuseventexplorer.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.campuseventexplorer.data.CampusEvent
import com.priyabajaria.cs501.campuseventexplorer.ui.components.CategoryChip
import com.priyabajaria.cs501.campuseventexplorer.ui.components.IconLabel

/** The text part of a card: category, title, time and location. */
@Composable
fun EventCardContent(event: CampusEvent, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(start = 16.dp, top = 14.dp, bottom = 14.dp, end = 8.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        CategoryChip(event.category)
        Text(
            text = event.title,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        IconLabel(Icons.Filled.DateRange, event.time)
        IconLabel(Icons.Filled.Place, event.location)
    }
}