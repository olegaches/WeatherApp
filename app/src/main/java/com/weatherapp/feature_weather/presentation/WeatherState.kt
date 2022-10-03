package com.weatherapp.feature_weather.presentation

import com.weatherapp.core.util.UiText
import com.weatherapp.feature_weather.domain.weather.WeatherData

data class WeatherState(
    val selectedDay: Int = 0,
    val weatherInfo: Map<Int, List<WeatherData>>? = null,
    val isLoading: Boolean = false,
    val error: UiText? = null
)
