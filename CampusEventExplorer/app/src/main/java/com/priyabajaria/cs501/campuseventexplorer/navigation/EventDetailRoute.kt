package com.priyabajaria.cs501.campuseventexplorer.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.priyabajaria.cs501.campuseventexplorer.data.EventRepository
import com.priyabajaria.cs501.campuseventexplorer.share.shareEvent
import com.priyabajaria.cs501.campuseventexplorer.ui.detail.EventDetailScreen

/**
 * Resolves the event ID from the route into an event (or null) and connects
 * the screen's Share action to the implicit share intent.
 */
@Composable
fun EventDetailRoute(eventId: Long, onBack: () -> Unit) {
    val context = LocalContext.current
    val event = remember(eventId) { EventRepository.findById(eventId) }

    EventDetailScreen(
        event = event,
        onBack = onBack,
        onShare = { event?.let { shareEvent(context, it) } }
    )
}