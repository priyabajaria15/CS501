package com.priyabajaria.cs501.focus_plan_builder.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FocusPlanInputSection(
    subject: String,
    minutesText: String,
    canCreatePlan: Boolean,
    onSubjectChange: (String) -> Unit,
    onMinutesChange: (String) -> Unit,
    onCreatePlan: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(22.dp),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            InputSectionHeader()

            StudySubjectField(
                subject = subject,
                onSubjectChange = onSubjectChange
            )

            MinutesField(
                minutesText = minutesText,
                onMinutesChange = onMinutesChange
            )

            DurationGuide()

            CreatePlanButton(
                enabled = canCreatePlan,
                onClick = onCreatePlan
            )
        }
    }
}