package com.alenabekrina.weathersun.dagger

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(private val mApplication: Application){
    @Provides
    @Singleton
    fun providesApplication(): Application {
        return mApplication
    }
}