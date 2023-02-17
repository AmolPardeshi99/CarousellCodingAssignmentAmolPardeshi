package com.example.amolpardeshi_standardarchitecuture.repo

import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
import com.example.amolpardeshi_standardarchitecuture.utils.Resource

interface BaseRepository {

    suspend fun getNewsData(): Resource<List<NewsResponseDto>>?
}