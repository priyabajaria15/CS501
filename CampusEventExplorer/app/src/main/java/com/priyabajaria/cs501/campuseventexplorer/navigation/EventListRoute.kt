package com.priyabajaria.cs501.campuseventexplorer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.priyabajaria.cs501.campuseventexplorer.data.EventRepository
import com.priyabajaria.cs501.campuseventexplorer.ui.list.EventListScreen

/**
 * State holder for the list destination. This composable OWNS the search
 * text. It is the state-holding half; EventListScreen is the stateless half.
 *
 * rememberSaveable stores the query in the back-stack entry's saved state, so
 * it survives rotation (Activity recreation) and a trip to the detail screen.
 */
@Composable
fun EventListRoute(onEventSelected: (Long) -> Unit) {
    var query by rememberSaveable { mutableStateOf("") }

    // Derived from the query: recomputed when it changes, never stored as an
    // independent mutable list.
    val visibleEvents = remember(query) { EventRepository.filter(query) }

    EventListScreen(
        events = visibleEvents,
        query = query,
        onQueryChange = { query = it },
        onEventSelected = onEventSelected,
        totalCount = EventRepository.events.size
    )
}