package com.weatherapp.feature_weather.domain.weather

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?,
    val weatherPerHour: List<WeatherData>?
)
