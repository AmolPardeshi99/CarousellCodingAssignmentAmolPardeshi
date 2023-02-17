package com.example.amolpardeshi_standardarchitecuture.repo

import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
import com.example.amolpardeshi_standardarchitecuture.network.NewsApi
import com.example.amolpardeshi_standardarchitecuture.utils.Resource
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

class NewsRepositoryTest {

    private lateinit var repository: NewsRepository

    @Mock
    private lateinit var apiService: NewsApi

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        repository = NewsRepository(apiService)
    }

    @Test
    fun `getNewsData should return success`() {
        runBlocking {
            val mockResponse = Response.success(listOf(NewsResponseDto()))
            `when`(apiService.getNewsList()).thenReturn(mockResponse)
            val result = repository.getNewsData()
            assertNotNull(result)
            assertEquals(Resource.success(listOf(NewsResponseDto())), result)
        }
    }

    @Test
    fun `getNewsData should return error`() {
        runBlocking {
            val mockResponse = Response.error<List<NewsResponseDto>>(
                400,
                ResponseBody.create(MediaType.parse("application/json"), "")
            )
            `when`(apiService.getNewsList()).thenReturn(mockResponse)
            val result = repository.getNewsData()
            assertNotNull(result)
            assertEquals(Resource.error("Error", null), result)
        }
    }

}