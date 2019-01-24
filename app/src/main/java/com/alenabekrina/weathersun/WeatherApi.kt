package com.alenabekrina.weathersun

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface WeatherApi {
    @GET
    fun getForecast(@Url url: String): Single<Response<ForecastJson>>
}