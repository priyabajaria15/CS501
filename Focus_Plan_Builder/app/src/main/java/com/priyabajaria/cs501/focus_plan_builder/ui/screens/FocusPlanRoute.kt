package com.priyabajaria.cs501.focus_plan_builder.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.priyabajaria.cs501.focus_plan_builder.model.FocusPlan
import com.priyabajaria.cs501.focus_plan_builder.util.durationCategory
import com.priyabajaria.cs501.focus_plan_builder.util.recommendedBreak

@Composable
fun FocusPlanRoute(
    modifier: Modifier = Modifier
) {
    var subject by rememberSaveable {
        mutableStateOf("")
    }

    var minutesText by rememberSaveable {
        mutableStateOf("")
    }

    var plan by remember {
        mutableStateOf<FocusPlan?>(null)
    }

    val minutes: Int? = minutesText.toIntOrNull()

    val canCreatePlan =
        subject.isNotBlank() &&
                minutes != null &&
                minutes in 10..180

    FocusPlanScreen(
        subject = subject,
        minutesText = minutesText,
        plan = plan,
        onSubjectChange = { newSubject ->
            subject = newSubject
            plan = null
        },
        onMinutesChange = { newMinutes ->
            minutesText = newMinutes
            plan = null
        },
        canCreatePlan = canCreatePlan,
        onCreatePlan = {
            minutes?.let { validMinutes ->
                if (subject.isNotBlank() && validMinutes in 10..180) {
                    plan = FocusPlan(
                        subject = subject.trim(),
                        minutes = validMinutes,
                        category = durationCategory(validMinutes),
                        breakMinutes = recommendedBreak(validMinutes)
                    )
                }
            }
        },
        modifier = modifier
    )
}