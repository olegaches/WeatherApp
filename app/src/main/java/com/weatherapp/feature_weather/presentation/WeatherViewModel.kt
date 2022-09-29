package com.weatherapp.feature_weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherapp.R
import com.weatherapp.core.domain.location.LocationTracker
import com.weatherapp.core.util.Resource
import com.weatherapp.core.util.UiText
import com.weatherapp.feature_weather.domain.use_case.GetWeatherDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherDataUseCase: GetWeatherDataUseCase,
    private val locationTracker: LocationTracker
): ViewModel() {

    private val _state = MutableStateFlow(WeatherState())
    val state = _state.asStateFlow()

    init {
        loadWeatherInfo()
    }

    // search binary

    fun loadWeatherInfo() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            locationTracker.getCurrentLocation()?.let { location ->
                getWeatherDataUseCase(location.latitude, location.longitude).collectLatest { result ->
                    when(result) {
                        is Resource.Success -> {
                            _state.emit(
                                WeatherState(
                                    weatherInfo = result.data,
                                    isLoading = false,
                                    error = null)
                            )
                        }
                        is Resource.Error -> {
                            _state.emit(
                                WeatherState(
                                    weatherInfo = null,
                                    isLoading = false,
                                    error = result.message)
                            )
                        }
                    }
                }
            } ?: kotlin.run {
                _state.update { it.copy(
                    isLoading = false,
                    error = UiText.StringResource(R.string.geolocation_exception)
                ) }
            }
        }
    }
}