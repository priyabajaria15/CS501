package com.priyabajaria.cs501.campuseventexplorer.ui.list

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.campuseventexplorer.data.CampusEvent
import com.priyabajaria.cs501.campuseventexplorer.ui.TestTags
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.categoryPalette

/**
 * One clickable row in the event list. It only arranges three pieces:
 * the accent strip, the text content and the chevron.
 */
@Composable
fun EventCard(
    event: CampusEvent,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .testTag(TestTags.eventCard(event.id)),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp, pressedElevation = 4.dp)
    ) {
        Row(Modifier.height(IntrinsicSize.Min)) {
            CategoryAccentStrip(color = categoryPalette(event.category).accent)
            EventCardContent(event = event, modifier = Modifier.weight(1f))
            CardChevron(modifier = Modifier.align(Alignment.CenterVertically))
        }
    }
}