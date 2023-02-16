package com.example.amolpardeshi_standardarchitecuture.di

import com.example.amolpardeshi_standardarchitecuture.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
}