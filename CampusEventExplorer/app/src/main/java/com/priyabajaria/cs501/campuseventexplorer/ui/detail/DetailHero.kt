package com.priyabajaria.cs501.campuseventexplorer.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.campuseventexplorer.data.CampusEvent
import com.priyabajaria.cs501.campuseventexplorer.ui.TestTags
import com.priyabajaria.cs501.campuseventexplorer.ui.components.CategoryChip
import com.priyabajaria.cs501.campuseventexplorer.ui.theme.CategoryPalette

/** Coloured band under the app bar with the category chip and the event title. */
@Composable
fun DetailHero(event: CampusEvent, palette: CategoryPalette, modifier: Modifier = Modifier) {
    Column(
        modifier
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
}