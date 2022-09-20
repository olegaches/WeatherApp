package com.weatherapp.feature_weather.domain.repository

import com.weatherapp.feature_weather.domain.weather.WeatherInfo
import com.weatherapp.core.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherData(latitude: Double, longitude: Double): Flow<Resource<WeatherInfo>>
}