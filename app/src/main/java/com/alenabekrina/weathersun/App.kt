package com.alenabekrina.weathersun

import android.app.Application
import com.alenabekrina.weathersun.dagger.AppComponent
import com.alenabekrina.weathersun.dagger.AppModule
import com.alenabekrina.weathersun.dagger.DaggerAppComponent
import com.alenabekrina.weathersun.dagger.RetrofitModule

class App: Application() {
    val component: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .retrofitModule(RetrofitModule())
            .build()
    }
    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}