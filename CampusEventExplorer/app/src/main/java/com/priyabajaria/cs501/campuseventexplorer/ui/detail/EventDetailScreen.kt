package com.priyabajaria.cs501.campuseventexplorer.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.campuseventexplorer.R
import com.priyabajaria.cs501.campuseventexplorer.data.CampusEvent
import com.priyabajaria.cs501.campuseventexplorer.data.EventRepository
import com.priyabajaria.cs501.campuseventexplorer.ui.TestTags
import com.priyabajaria.cs501.campuseventexplorer.ui.components.CategoryChip
import com.priyabajaria.cs501.campuseventexplorer.ui.components.InfoRow
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.CampusEventTheme
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.categoryPalette

/**
 * Stateless detail screen. A null [event] means the route's ID matched
 * nothing, so we show "Event unavailable" instead of crashing.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    event: CampusEvent?,
    onBack: () -> Unit,
    onShare: () -> Unit
) {
    val palette = event?.let { categoryPalette(it.category) }
    val barColor = palette?.container ?: MaterialTheme.colorScheme.surface

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.event_details)) },
                navigationIcon = {
                    // App-bar Up button.
                    IconButton(onClick = onBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.navigate_up)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = barColor,
                    titleContentColor = palette?.onContainer ?: MaterialTheme.colorScheme.onSurface,
                    navigationIconContentColor = palette?.onContainer
                        ?: MaterialTheme.colorScheme.onSurface
                )
            )
        },
        bottomBar = {
            if (event != null) ShareBar(onShare)
        }
    ) { padding ->
        if (event == null) {
            EventUnavailable(onReturn = onBack, modifier = Modifier.padding(padding))
        } else {
            DetailContent(event, Modifier.padding(padding))
        }
    }
}

@Composable
private fun DetailContent(event: CampusEvent, modifier: Modifier = Modifier) {
    val palette = categoryPalette(event.category)
    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        // Hero band continuing the app-bar colour.
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp))
                .background(palette.container)
                .padding(start = 20.dp, end = 20.dp, top = 4.dp, bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CategoryChip(event.category)
            Text(
                text = event.title,
                style = MaterialTheme.typography.headlineMedium,
                color = palette.onContainer,
                modifier = Modifier.testTag(TestTags.DETAIL_TITLE)
            )
        }

        Column(
            Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
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

            Column(
                Modifier.padding(horizontal = 4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = stringResource(R.string.label_about),
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = event.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}

/** Sticky bottom bar with the primary "Share event" action. */
@Composable
private fun ShareBar(onShare: () -> Unit) {
    Surface(tonalElevation = 3.dp, shadowElevation = 8.dp) {
        Button(
            onClick = onShare,
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .height(52.dp)
                .testTag(TestTags.SHARE_BUTTON),
            shape = RoundedCornerShape(26.dp),
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding
        ) {
            Icon(Icons.Filled.Share, contentDescription = null, modifier = Modifier.size(20.dp))
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(stringResource(R.string.share_event))
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