package com.alenabekrina.weathersun

import android.util.Base64
import android.util.Log
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.HttpUrl
import retrofit2.Response
import retrofit2.Retrofit
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets
import javax.inject.Inject

class WebService @Inject constructor(private val retrofit: Retrofit) {
    private val TAG = "WebService"
    private val urlBuilder: HttpUrl.Builder by lazy {
        val decoded = String(Base64.decode(getNativeKey(), Base64.URL_SAFE), Charset.forName("UTF-8"))
        HttpUrl.Builder()
            .scheme("https")
            .host("api.darksky.net")
            .addPathSegment("forecast")
            .addPathSegment(decoded)
    }

    companion object {
        private external fun getNativeKey(): String

        init {
            System.loadLibrary("native-lib")
        }
    }

    fun getForecast() {

        Base64.decode(getNativeKey(), Base64.URL_SAFE)

        val api = retrofit.create(WeatherApi::class.java)
        val url = urlBuilder.addPathSegment("42.3601,-71.0589").build()
        val stringUrl = url.toString()
        /*api.getForecast(url.toString()).subscribeOn(Schedulers.io())
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

            })*/
    }
}