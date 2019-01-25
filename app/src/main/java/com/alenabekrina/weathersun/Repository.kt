package com.alenabekrina.weathersun

import javax.inject.Inject

class Repository @Inject constructor(private val webService: WebService) {
    private val TAG = "Repository"

    fun getForecast() {
        webService.getForecast()
    }
}