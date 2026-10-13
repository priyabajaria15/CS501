package com.priyabajaria.cs501.campuseventexplorer.ui.list

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.campuseventexplorer.data.EventRepository
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.CampusEventTheme

// Android Studio previews for the list screen pieces (open the Split/Design view).

@Preview(showBackground = true)
@Composable
private fun EventCardPreview() {
    CampusEventTheme {
        EventCard(EventRepository.events.first(), onClick = {}, modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun ListHeaderPreview() {
    CampusEventTheme {
        ListHeader(shown = 4, total = 10, query = "tech", onQueryChange = {})
    }
}

@Preview(showBackground = true, heightDp = 720)
@Composable
private fun EventListPreview() {
    CampusEventTheme {
        EventListScreen(
            events = EventRepository.events,
            query = "",
            onQueryChange = {},
            onEventSelected = {}
        )
    }
}

@Preview(showBackground = true, heightDp = 480)
@Composable
private fun EventListEmptyPreview() {
    CampusEventTheme {
        EventListScreen(
            events = emptyList(),
            query = "zzz",
            onQueryChange = {},
            onEventSelected = {},
            totalCount = 10
        )
    }
}