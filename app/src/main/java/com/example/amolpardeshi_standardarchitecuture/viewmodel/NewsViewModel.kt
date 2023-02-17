package com.example.amolpardeshi_standardarchitecuture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
import com.example.amolpardeshi_standardarchitecuture.repo.BaseRepository
import com.example.amolpardeshi_standardarchitecuture.utils.Status
import kotlinx.coroutines.launch

class NewsViewModel(private val repository: BaseRepository) : ViewModel() {

    private val _newsLiveData: MutableLiveData<List<NewsResponseDto>> = MutableLiveData()
    val newsLiveData: LiveData<List<NewsResponseDto>> = _newsLiveData


    fun getData() = viewModelScope.launch {
        val result = repository.getNewsData()
        if (result?.status == Status.SUCCESS) {
            result.data?.let { data ->
                _newsLiveData.postValue(data.sortedByDescending { it.timeCreated })
            }
        }
    }

    fun sortByRecent() {
        _newsLiveData.postValue(_newsLiveData.value?.sortedByDescending { it.timeCreated })
    }

    fun sortByPopular() {
        _newsLiveData.postValue(
            _newsLiveData.value?.sortedWith(compareBy<NewsResponseDto> { it.rank }.thenByDescending { it.timeCreated })
        )
    }

}