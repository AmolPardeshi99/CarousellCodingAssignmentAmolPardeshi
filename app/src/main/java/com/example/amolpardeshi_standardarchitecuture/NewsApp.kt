package com.example.amolpardeshi_standardarchitecuture

import android.app.Application
import com.example.amolpardeshi_standardarchitecuture.di.ApplicationComponent
import com.example.amolpardeshi_standardarchitecuture.di.DaggerApplicationComponent

class NewsApp : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}