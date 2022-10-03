package com.weatherapp.feature_weather.domain.repository

import com.weatherapp.core.util.Resource
import com.weatherapp.feature_weather.domain.weather.WeatherData
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherData(latitude: Double, longitude: Double): Flow<Resource<Map<Int, List<WeatherData>>>>
}