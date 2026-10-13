package com.priyabajaria.cs501.campuseventexplorer.ui.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.priyabajaria.cs501.campuseventexplorer.data.CampusEvent
import com.priyabajaria.cs501.campuseventexplorer.data.EventRepository
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.CampusEventTheme
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.categoryPalette

/**
 * Stateless detail screen. It only arranges the pieces: top bar, content and
 * share bar. A null [event] means the route's ID matched nothing, so we show
 * "Event unavailable" instead of crashing.
 */
@Composable
fun EventDetailScreen(
    event: CampusEvent?,
    onBack: () -> Unit,
    onShare: () -> Unit
) {
    val palette = event?.let { categoryPalette(it.category) }

    Scaffold(
        topBar = { DetailTopBar(palette = palette, onBack = onBack) },
        bottomBar = { if (event != null) ShareBar(onShare = onShare) }
    ) { padding ->
        if (event == null) {
            EventUnavailable(onReturn = onBack, modifier = Modifier.padding(padding))
        } else {
            DetailContent(event = event, modifier = Modifier.padding(padding))
        }
    }
}

@Preview(showBackground = true, heightDp = 760)
@Composable
private fun EventDetailPreview() {
    CampusEventTheme {
        EventDetailScreen(event = EventRepository.events.first(), onBack = {}, onShare = {})
    }
}

@Preview(showBackground = true, heightDp = 600)
@Composable
private fun EventUnavailablePreview() {
    CampusEventTheme {
        EventDetailScreen(event = null, onBack = {}, onShare = {})
    }
}