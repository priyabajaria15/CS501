package com.priyabajaria.cs501.mobilitylens.data

import androidx.annotation.StringRes

data class MobilityDimension(
    @StringRes val nameRes: Int,
    @StringRes val constraintRes: Int,
    @StringRes val implicationRes: Int
)