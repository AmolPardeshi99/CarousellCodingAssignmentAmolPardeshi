package com.example.amolpardeshi_standardarchitecuture.di

import com.example.amolpardeshi_standardarchitecuture.network.NewsApi
import com.example.amolpardeshi_standardarchitecuture.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAPIService(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java)
    }
}