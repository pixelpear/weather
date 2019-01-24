package com.alenabekrina.weathersun.dagger

import android.app.Application
import com.alenabekrina.weathersun.MainActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RetrofitModule::class])
interface AppComponent {
    fun injectMainActivity(activity: MainActivity)
    fun inject(application: Application)
    fun applicationContext(): Application
    fun retrofit(): Retrofit
}