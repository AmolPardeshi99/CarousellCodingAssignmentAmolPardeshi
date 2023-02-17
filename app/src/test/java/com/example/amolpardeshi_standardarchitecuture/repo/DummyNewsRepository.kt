package com.example.amolpardeshi_standardarchitecuture.repo

import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
import com.example.amolpardeshi_standardarchitecuture.utils.Resource

class DummyNewsRepository:BaseRepository {

    private var shouldReturnNetworkError = false
    private val newsItems = mutableListOf<NewsResponseDto>()


    fun setShouldReturnNetworkError(value:Boolean){
        shouldReturnNetworkError = value
    }

    override suspend fun getNewsData(): Resource<List<NewsResponseDto>> {
        return if (shouldReturnNetworkError){
             Resource.error("Opps! Something went wrong",null)
        }else{
            Resource.success(listOf(NewsResponseDto()))
        }
    }

}