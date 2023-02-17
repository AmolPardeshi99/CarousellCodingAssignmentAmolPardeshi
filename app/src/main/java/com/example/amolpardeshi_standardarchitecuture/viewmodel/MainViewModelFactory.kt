package com.example.amolpardeshi_standardarchitecuture.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.amolpardeshi_standardarchitecuture.repo.NewsRepository
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val repository: NewsRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(repository) as T
    }
}