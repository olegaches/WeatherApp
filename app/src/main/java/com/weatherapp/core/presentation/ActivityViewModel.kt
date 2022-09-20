package com.weatherapp.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weatherapp.R
import com.weatherapp.core.domain.location.LocationTracker
import com.weatherapp.core.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(
    private val locationTracker: LocationTracker
): ViewModel() {

    private val _state = MutableStateFlow(ActivityState(isLoading = true))
    val state = _state.asStateFlow()

    fun confirmPermissions() {
        _state.value = ActivityState(isLoading = false, error = null)
    }
//    fun getLocation() {
//        viewModelScope.launch {
//            locationTracker.getCurrentLocation()?.let {
//
//            } ?: kotlin.run {
//                _state.emit(
//                    ActivityState(
//                        isLoading = false,
//                        error = UiText.StringResource(R.string.geolocation_exception)
//                    )
//                )
//            }
//        }
//    }
}