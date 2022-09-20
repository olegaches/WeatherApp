package com.weatherapp.feature_weather.domain.weather

import androidx.annotation.DrawableRes
import com.weatherapp.R
import com.weatherapp.core.util.UiText

enum class WeatherType(
    val weatherDesc: UiText,
    @DrawableRes val iconRes: Int
) {
    ClearSky(
        weatherDesc = UiText.StringResource(R.string.clear_sky),
        iconRes = R.drawable.ic_sunny
    ),
    MainlyClear(
        weatherDesc = UiText.StringResource(R.string.mainly_clear),
        iconRes = R.drawable.ic_cloudy
    ),
    PartlyCloudy(
        weatherDesc = UiText.StringResource(R.string.partly_cloudy),
        iconRes = R.drawable.ic_cloudy
    ),
    Overcast(
        weatherDesc = UiText.StringResource(R.string.overcast),
        iconRes = R.drawable.ic_cloudy
    ),
    Foggy(
        weatherDesc = UiText.StringResource(R.string.foggy),
        iconRes = R.drawable.ic_very_cloudy
    ),
    DepositingRimeFog(
        weatherDesc = UiText.StringResource(R.string.depositing_rime_fog),
        iconRes = R.drawable.ic_very_cloudy
    ),
    LightDrizzle(
        weatherDesc = UiText.StringResource(R.string.light_drizzle),
        iconRes = R.drawable.ic_rainshower
    ),
    ModerateDrizzle(
        weatherDesc = UiText.StringResource(R.string.moderate_drizzle),
        iconRes = R.drawable.ic_rainshower
    ),
    DenseDrizzle(
        weatherDesc = UiText.StringResource(R.string.dense_drizzle),
        iconRes = R.drawable.ic_rainshower
    ),
    LightFreezingDrizzle(
        weatherDesc = UiText.StringResource(R.string.slight_freezing_drizzle),
        iconRes = R.drawable.ic_snowyrainy
    ),
    DenseFreezingDrizzle(
        weatherDesc = UiText.StringResource(R.string.dense_freezing_drizzle),
        iconRes = R.drawable.ic_snowyrainy
    ),
    SlightRain(
        weatherDesc = UiText.StringResource(R.string.slight_rain),
        iconRes = R.drawable.ic_rainy
    ),
    ModerateRain(
        weatherDesc = UiText.StringResource(R.string.rainy),
        iconRes = R.drawable.ic_rainy
    ),
    HeavyRain(
        weatherDesc = UiText.StringResource(R.string.heavy_rain),
        iconRes = R.drawable.ic_rainy
    ),
    HeavyFreezingRain(
        weatherDesc = UiText.StringResource(R.string.heavy_freezing_rain),
        iconRes = R.drawable.ic_snowyrainy
    ),
    SlightSnowFall(
        weatherDesc = UiText.StringResource(R.string.slight_snow_fall),
        iconRes = R.drawable.ic_snowy
    ),
    ModerateSnowFall(
        weatherDesc = UiText.StringResource(R.string.moderate_snow_fall),
        iconRes = R.drawable.ic_heavysnow
    ),
    HeavySnowFall(
        weatherDesc = UiText.StringResource(R.string.heavy_snow_fall),
        iconRes = R.drawable.ic_heavysnow
    ),
    SnowGrains(
        weatherDesc = UiText.StringResource(R.string.snow_grains),
        iconRes = R.drawable.ic_heavysnow
    ),
    SlightRainShowers(
        weatherDesc = UiText.StringResource(R.string.slight_rain_showers),
        iconRes = R.drawable.ic_rainshower
    ),
    ModerateRainShowers(
        weatherDesc = UiText.StringResource(R.string.moderate_rain_showers),
        iconRes = R.drawable.ic_rainshower
    ),
    ViolentRainShowers(
        weatherDesc = UiText.StringResource(R.string.violent_rain_showers),
        iconRes = R.drawable.ic_rainshower
    ),
    SlightSnowShowers(
        weatherDesc = UiText.StringResource(R.string.light_snow_showers),
        iconRes = R.drawable.ic_snowy
    ),
    HeavySnowShowers(
        weatherDesc = UiText.StringResource(R.string.heavy_snow_showers),
        iconRes = R.drawable.ic_snowy
    ),
    ModerateThunderstorm(
        weatherDesc = UiText.StringResource(R.string.moderate_thundershorm),
        iconRes = R.drawable.ic_thunder
    ),
    SlightHailThunderstorm(
        weatherDesc = UiText.StringResource(R.string.thunderstorm_with_slight_hail),
        iconRes = R.drawable.ic_rainythunder
    ),
    HeavyHailThunderstorm(
        weatherDesc = UiText.StringResource(R.string.thunderstorm_with_heavy_hail),
        iconRes = R.drawable.ic_rainythunder
    );

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when(code) {
                0 -> ClearSky
                1 -> MainlyClear
                2 -> PartlyCloudy
                3 -> Overcast
                45 -> Foggy
                48 -> DepositingRimeFog
                51 -> LightDrizzle
                53 -> ModerateDrizzle
                55 -> DenseDrizzle
                56 -> LightFreezingDrizzle
                57 -> DenseFreezingDrizzle
                61 -> SlightRain
                63 -> ModerateRain
                65 -> HeavyRain
                66 -> LightFreezingDrizzle
                67 -> HeavyFreezingRain
                71 -> SlightSnowFall
                73 -> ModerateSnowFall
                75 -> HeavySnowFall
                77 -> SnowGrains
                80 -> SlightRainShowers
                81 -> ModerateRainShowers
                82 -> ViolentRainShowers
                85 -> SlightSnowShowers
                86 -> HeavySnowShowers
                95 -> ModerateThunderstorm
                96 -> SlightHailThunderstorm
                99 -> HeavyHailThunderstorm
                else -> ClearSky
            }
        }
    }
}