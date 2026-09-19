package com.priyabajaria.cs501.focus_plan_builder.util

fun durationCategory(minutes: Int): String {
    return when {
        minutes < 10 -> "Invalid"
        minutes in 10..29 -> "Quick review"
        minutes in 30..60 -> "Focused session"
        else -> "Extended session"
    }
}

fun recommendedBreak(minutes: Int): Int {
    return when {
        minutes in 10..29 -> 5
        minutes in 30..60 -> 10
        else -> 15
    }
}