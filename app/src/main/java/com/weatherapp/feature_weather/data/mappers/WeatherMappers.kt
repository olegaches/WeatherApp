package com.weatherapp.feature_weather.data.mappers

import com.weatherapp.feature_weather.data.remote.dto.WeatherDataDto
import com.weatherapp.feature_weather.data.remote.dto.WeatherDto
import com.weatherapp.feature_weather.domain.weather.WeatherData
import com.weatherapp.feature_weather.domain.weather.WeatherInfo
import com.weatherapp.feature_weather.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperatures[index],
                pressure = pressures[index],
                windSpeed = windSpeeds[index],
                humidity = humidities[index],
                weatherType = WeatherType.fromWMO(weatherCodes[index])
            )
        )
    }.groupBy {
        it.index / 24
    }.mapValues { it ->
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        it.time.hour == now.hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        currentWeatherData = currentWeatherData,
        weatherPerHour = weatherDataMap[0]?.filter { it.time.hour >= now.hour }
    )
}