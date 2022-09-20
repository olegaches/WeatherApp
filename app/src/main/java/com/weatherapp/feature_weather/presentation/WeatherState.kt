package com.weatherapp.feature_weather.presentation

import com.weatherapp.core.util.UiText
import com.weatherapp.feature_weather.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: UiText? = null
)
