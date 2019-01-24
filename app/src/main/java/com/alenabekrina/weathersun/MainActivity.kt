package com.alenabekrina.weathersun

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MainActivity: AppCompatActivity() {
    private val TAG = "MainActivity"
    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).component.injectMainActivity(this)

        val data = repository.getForecast()
    }
}