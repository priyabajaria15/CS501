package com.priyabajaria.cs501.mobilitylens.data

import com.priyabajaria.cs501.mobilitylens.R

val mobilityDimensions = listOf(
    MobilityDimension(
        nameRes = R.string.dimension_input_name,
        constraintRes = R.string.dimension_input_constraint,
        implicationRes = R.string.dimension_input_implication
    ),
    MobilityDimension(
        nameRes = R.string.dimension_screen_name,
        constraintRes = R.string.dimension_screen_constraint,
        implicationRes = R.string.dimension_screen_implication
    ),
    MobilityDimension(
        nameRes = R.string.dimension_lifecycle_name,
        constraintRes = R.string.dimension_lifecycle_constraint,
        implicationRes = R.string.dimension_lifecycle_implication
    ),
    MobilityDimension(
        nameRes = R.string.dimension_context_name,
        constraintRes = R.string.dimension_context_constraint,
        implicationRes = R.string.dimension_context_implication
    ),
    MobilityDimension(
        nameRes = R.string.dimension_usage_name,
        constraintRes = R.string.dimension_usage_constraint,
        implicationRes = R.string.dimension_usage_implication
    ),
    MobilityDimension(
        nameRes = R.string.dimension_privacy_name,
        constraintRes = R.string.dimension_privacy_constraint,
        implicationRes = R.string.dimension_privacy_implication
    )
)