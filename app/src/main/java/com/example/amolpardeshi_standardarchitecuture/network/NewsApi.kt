package com.example.amolpardeshi_standardarchitecuture.network

import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface NewsApi {

    @GET("carousell-interview-assets/android/carousell_news.json")
    suspend fun getNewsList(): Response<List<NewsResponseDto>>
}