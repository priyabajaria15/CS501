package com.priyabajaria.cs501.focus_plan_builder.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StudySubjectField(
    subject: String,
    onSubjectChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = subject,
        onValueChange = onSubjectChange,
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(text = "Study subject")
        },
        placeholder = {
            Text(text = "Kotlin, Databases, Compose state...")
        },
        supportingText = {
            Text(
                text = if (subject.isBlank()) {
                    "What are you focusing on today?"
                } else {
                    "Great choice! Keep going 🌟"
                }
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(18.dp),
        colors = focusFieldColors()
    )
}