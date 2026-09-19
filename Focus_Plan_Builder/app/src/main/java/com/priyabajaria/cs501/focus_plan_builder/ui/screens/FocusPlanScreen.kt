package com.priyabajaria.cs501.focus_plan_builder.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.priyabajaria.cs501.focus_plan_builder.model.FocusPlan
import com.priyabajaria.cs501.focus_plan_builder.ui.components.header.AppHeader
import com.priyabajaria.cs501.focus_plan_builder.ui.components.FocusPlanInputSection
import com.priyabajaria.cs501.focus_plan_builder.ui.components.FocusPlanResultCard

@Composable
fun FocusPlanScreen(
    subject: String,
    minutesText: String,
    plan: FocusPlan?,
    onSubjectChange: (String) -> Unit,
    onMinutesChange: (String) -> Unit,
    canCreatePlan: Boolean,
    onCreatePlan: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .statusBarsPadding()
            .windowInsetsPadding(WindowInsets.navigationBars)
            .imePadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 18.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        AppHeader()

        FocusPlanInputSection(
            subject = subject,
            minutesText = minutesText,
            canCreatePlan = canCreatePlan,
            onSubjectChange = onSubjectChange,
            onMinutesChange = onMinutesChange,
            onCreatePlan = onCreatePlan,
            modifier = Modifier.fillMaxWidth()
        )

        if (plan != null) {
            FocusPlanResultCard(
                plan = plan
            )
        }

        Spacer(modifier = Modifier.padding(bottom = 4.dp))
    }
}