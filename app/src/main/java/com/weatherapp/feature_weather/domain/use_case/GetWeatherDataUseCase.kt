package com.weatherapp.feature_weather.domain.use_case

import com.weatherapp.core.util.Resource
import com.weatherapp.feature_weather.domain.repository.WeatherRepository
import com.weatherapp.feature_weather.domain.weather.WeatherInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherDataUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(latitude: Double, longitude: Double): Flow<Resource<WeatherInfo>> {
        return repository.getWeatherData(latitude, longitude)
    }
}