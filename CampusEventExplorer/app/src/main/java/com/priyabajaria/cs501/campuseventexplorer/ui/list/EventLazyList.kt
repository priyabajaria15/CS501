package com.priyabajaria.cs501.campuseventexplorer.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.campuseventexplorer.data.CampusEvent
import com.priyabajaria.cs501.campuseventexplorer.ui.TestTags

/** The scrolling list of event cards, keyed by event ID. */
@Composable
fun EventLazyList(
    events: List<CampusEvent>,
    onEventSelected: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val navBarBottom = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag(TestTags.EVENT_LIST),
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 16.dp + navBarBottom
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Stable key = event ID, so rows keep identity as the filter changes.
        items(items = events, key = { it.id }) { event ->
            EventCard(
                event = event,
                onClick = { onEventSelected(event.id) },
                modifier = Modifier.animateItem()
            )
        }
    }
}