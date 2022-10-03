package com.weatherapp.feature_weather.presentation

import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.weatherapp.R
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.weatherapp.core.presentation.ui.theme.DarkBlue
import com.weatherapp.core.presentation.ui.theme.DeepBlue
import com.weatherapp.feature_weather.presentation.components.DayList
import com.weatherapp.feature_weather.presentation.components.WeatherCard
import com.weatherapp.feature_weather.presentation.components.WeatherForecast

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {

    val state = viewModel.state.collectAsState().value

    SwipeRefresh(
        state = rememberSwipeRefreshState(false),
        onRefresh = {
            viewModel.loadWeatherInfo()
        }) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DarkBlue)
            ) {
                if(state.error == null && !state.isLoading) {
                    item {
                        state.weatherInfo?.let { DayList(it) }
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherCard(
                            state = state,
                            backgroundColor = DeepBlue
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        WeatherForecast(state = state)
                    }
                }
            }

            if(state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            state.error?.let { error ->
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = error.asString(),
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                    )
                    TextButton(
                        onClick = {
                            viewModel.loadWeatherInfo()
                        },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),

                        ) {
                        Text(text = stringResource(R.string.refresh_page_tip))
                    }
                }
            }
        }
    }
}