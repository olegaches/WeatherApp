package com.weatherapp.feature_weather.presentation.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.weatherapp.feature_weather.domain.weather.WeatherData
import com.weatherapp.feature_weather.presentation.WeatherViewModel

@Composable
fun DayList(
    weatherDataPerDay: Map<Int, List<WeatherData>>,
    viewModel: WeatherViewModel = hiltViewModel()
) {
    LazyRow {
        items(weatherDataPerDay.size) { dayNum ->
            DayListItem(
                isSelected = viewModel.state.value.selectedDay == dayNum,
                dateTime = weatherDataPerDay[dayNum]!![0].time,
                onItemClick = { viewModel.selectDay(dayNum) }
            )
        }
    }
}