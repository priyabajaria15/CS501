package com.priyabajaria.cs501.focus_plan_builder.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.focus_plan_builder.model.FocusPlan

@Composable
fun FocusPlanResultCard(
    plan: FocusPlan,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ResultHeader(
                subject = plan.subject
            )

            HorizontalDivider(
                color = MaterialTheme.colorScheme.primary.copy(
                    alpha = 0.18f
                )
            )

            PlanSummaryRow(
                minutes = plan.minutes,
                category = plan.category
            )

            BreakReminder(
                subject = plan.subject,
                minutes = plan.minutes,
                breakMinutes = plan.breakMinutes
            )
        }
    }
}