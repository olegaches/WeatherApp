package com.weatherapp.feature_weather.data.repository

import com.weatherapp.R
import com.weatherapp.core.util.Resource
import com.weatherapp.core.util.UiText
import com.weatherapp.feature_weather.data.mappers.toWeatherInfo
import com.weatherapp.feature_weather.data.remote.WeatherApi
import com.weatherapp.feature_weather.domain.repository.WeatherRepository
import com.weatherapp.feature_weather.domain.weather.WeatherInfo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.*
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override fun getWeatherData(latitude: Double, longitude: Double): Flow<Resource<WeatherInfo>> = flow {
        try {
            val data = api.getWeatherData(
                latitude = latitude,
                longitude = longitude,
                timezone = Calendar.getInstance().timeZone.id
            ).toWeatherInfo()
            emit(Resource.Success(data))
        }
        catch(e: HttpException) {
            if(e.localizedMessage.isNullOrEmpty()) {
                emit(Resource.Error(UiText.StringResource(R.string.unknown_exception)))
            }
            else {
                emit(Resource.Error(UiText.DynamicString(e.localizedMessage!!)))
            }
        } catch(e: IOException) {
            emit(Resource.Error(UiText.StringResource(R.string.io_exception)))
        }
    }
}