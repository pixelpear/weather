package com.alenabekrina.weathersun

import android.util.Log
import io.reactivex.Single
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class Repository @Inject constructor(val retrofit: Retrofit){
    private val TAG = "Repository"
    fun getForecast() {
        val api = retrofit.create(WeatherApi::class.java)
        api.getForecast("").subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: SingleObserver<Response<ForecastJson>> {
                override fun onError(e: Throwable) {
                    Log.e(TAG, "error in data stream", e)
                }

                override fun onSubscribe(d: Disposable) {
                    Log.i(TAG, "subscribed to forecast")
                }

                override fun onSuccess(t: Response<ForecastJson>) {
                    Log.i(TAG, "got the forecast!")
                }

            })
    }
}