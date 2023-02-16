package com.example.amolpardeshi_standardarchitecuture.repo

import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
import com.example.amolpardeshi_standardarchitecuture.network.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService : NewsApi){

    suspend fun getNewsData(): List<NewsResponseDto>? {
        val result = apiService.getNewsList()

        if (result.isSuccessful && result.body()!=null){
            return result.body()
        }
        return null;
    }
}