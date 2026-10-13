package com.priyabajaria.cs501.campuseventexplorer.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.campuseventexplorer.R
import com.priyabajaria.cs501.campuseventexplorer.data.CampusEvent
import com.priyabajaria.cs501.campuseventexplorer.ui.components.InfoRow
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.CategoryPalette

/** Card with two labelled rows: date/time and location. */
@Composable
fun DetailInfoCard(event: CampusEvent, palette: CategoryPalette, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
            InfoRow(
                icon = Icons.Filled.DateRange,
                label = stringResource(R.string.label_when),
                value = event.time,
                iconContainer = palette.container,
                iconTint = palette.accent
            )
            HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
            InfoRow(
                icon = Icons.Filled.Place,
                label = stringResource(R.string.label_where),
                value = event.location,
                iconContainer = palette.container,
                iconTint = palette.accent
            )
        }
    }
}