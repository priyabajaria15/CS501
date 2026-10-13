package com.priyabajaria.cs501.campuseventexplorer.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.priyabajaria.cs501.campuseventexplorer.data.CampusEvent

/**
 * Stateless list screen. It receives the already-filtered events and the
 * current query, and reports user intent through callbacks. It never sees a
 * NavController.
 *
 * @param totalCount size of the full collection, used for the "x of y" subtitle.
 */
@Composable
fun EventListScreen(
    events: List<CampusEvent>,
    query: String,
    onQueryChange: (String) -> Unit,
    onEventSelected: (Long) -> Unit,
    modifier: Modifier = Modifier,
    totalCount: Int = events.size
) {
    val keyboard = LocalSoftwareKeyboardController.current

    Column(
        modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        ListHeader(
            shown = events.size,
            total = totalCount,
            query = query,
            onQueryChange = onQueryChange
        )

        if (events.isEmpty()) {
            EmptyResults(query)
        } else {
            EventLazyList(
                events = events,
                onEventSelected = { id ->
                    keyboard?.hide()
                    onEventSelected(id)
                }
            )
        }
    }
}