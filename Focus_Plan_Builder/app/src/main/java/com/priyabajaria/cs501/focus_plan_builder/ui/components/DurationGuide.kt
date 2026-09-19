package com.priyabajaria.cs501.focus_plan_builder.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DurationGuide(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "⚡ Pick your focus level",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = FontWeight.SemiBold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DurationChip(
                emoji = "🌱",
                title = "Quick",
                range = "10–29",
                modifier = Modifier.weight(1f)
            )

            DurationChip(
                emoji = "🎯",
                title = "Focus",
                range = "30–60",
                modifier = Modifier.weight(1f)
            )

            DurationChip(
                emoji = "🔥",
                title = "Deep",
                range = "61–180",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun DurationChip(
    emoji: String,
    title: String,
    range: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = 6.dp,
                vertical = 11.dp
            ),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Text(
                text = "$emoji $title",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "$range min",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}