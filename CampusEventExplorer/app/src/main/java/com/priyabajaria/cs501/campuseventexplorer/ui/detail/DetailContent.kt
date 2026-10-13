package com.priyabajaria.cs501.campuseventexplorer.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.campuseventexplorer.data.CampusEvent
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.categoryPalette

/** Scrollable body of the detail screen: hero, info card and description. */
@Composable
fun DetailContent(event: CampusEvent, modifier: Modifier = Modifier) {
    val palette = categoryPalette(event.category)

    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        DetailHero(event = event, palette = palette)

        Column(
            Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DetailInfoCard(event = event, palette = palette)
            AboutSection(description = event.description)
            Spacer(Modifier.height(8.dp))
        }
    }
}