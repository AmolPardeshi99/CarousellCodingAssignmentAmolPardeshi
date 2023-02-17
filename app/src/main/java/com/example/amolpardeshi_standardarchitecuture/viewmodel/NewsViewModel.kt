package com.example.amolpardeshi_standardarchitecuture.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
import com.example.amolpardeshi_standardarchitecuture.repo.BaseRepository
import com.example.amolpardeshi_standardarchitecuture.utils.Status
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: BaseRepository) : ViewModel() {

    val newsLiveData: MutableLiveData<List<NewsResponseDto>> = MutableLiveData()
//    val newsLiveData: LiveData<List<NewsResponseDto>> = _newsLiveData


    fun getData() = viewModelScope.launch {
        val result = repository.getNewsData()
        if (result?.status == Status.SUCCESS) {
            result.data?.let { data ->
                newsLiveData.postValue(data.sortedByDescending { it.timeCreated })
            }
        }
    }

    fun sortByRecent() {
        newsLiveData.postValue(newsLiveData.value?.sortedByDescending { it.timeCreated })
    }

    fun sortByPopular() {
        newsLiveData.postValue(
            newsLiveData.value?.sortedWith(compareBy<NewsResponseDto> { it.rank }.thenByDescending { it.timeCreated })
        )
    }

}