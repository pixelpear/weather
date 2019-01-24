package com.alenabekrina.weathersun

class CurrentlyJson(
    val time: Int,
    val summary: String,
    val icon: String,
    val nearestStormDistance: Int,
    val precipIntensity: Float,
    val precipIntensityError: Float,
    val precipProbability: Float,
    val precipType: String,
    val temperature: Float,
    val apparentTemperature: Float,
    val dewPoint: Float,
    val humidity: Float,
    val pressure: Float,
    val windSpeed: Float,
    val windGust: Float,
    val windBearing: Int,
    val cloudCover: Int,
    val uvIndex: Int,
    val visibility: Float,
    val ozone: Float)