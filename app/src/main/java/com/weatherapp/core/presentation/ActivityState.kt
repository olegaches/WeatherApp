package com.weatherapp.core.presentation

import com.weatherapp.core.util.UiText

data class ActivityState (
    var isLoading: Boolean = false,
    var error: UiText? = null,
)