package com.weatherapp.feature_weather.data.remote

import com.weatherapp.feature_weather.data.remote.dto.WeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeatherData(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("timezone") timezone: String
    ): WeatherDto

    companion object {
        const val BASE_URL = "https://api.open-meteo.com/"
    }
}