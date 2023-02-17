package com.example.amolpardeshi_standardarchitecuture.repo

import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
import com.example.amolpardeshi_standardarchitecuture.network.NewsApi
import com.example.amolpardeshi_standardarchitecuture.utils.Resource
import javax.inject.Inject

class NewsRepository @Inject constructor(private val apiService : NewsApi):BaseRepository{

    /**
     * ...check good flow
     * ...check error flow - throw exception
     * ...success but data null
     * **/
    override suspend fun getNewsData(): Resource<List<NewsResponseDto>>? {
        val result = apiService.getNewsList()
        if (result.isSuccessful && result.body()!=null){
            return Resource.success(result.body())
        }
        return  Resource.error("Error", null)
    }
}