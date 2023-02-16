package com.example.amolpardeshi_standardarchitecuture.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
import com.example.amolpardeshi_standardarchitecuture.repo.NewsRepository
import kotlinx.coroutines.launch
import java.util.Comparator

class MainViewModel(private val repository: NewsRepository) : ViewModel() {

    val newsLiveData: MutableLiveData<List<NewsResponseDto>> = MutableLiveData()

    fun getData() {
        viewModelScope.launch {
            val data = repository.getNewsData()
            newsLiveData.postValue(data?.sortedByDescending { it.timeCreated })
        }
    }

    fun sortByRecent() {
        newsLiveData.postValue(newsLiveData.value?.sortedByDescending { it.timeCreated })
    }

    fun sortByPopular() {
        newsLiveData.postValue(
            newsLiveData.value?.sortedWith(compareBy<NewsResponseDto>{ it.rank }.thenByDescending{ it.timeCreated })
        )
    }

}