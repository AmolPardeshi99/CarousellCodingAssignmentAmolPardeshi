package com.example.amolpardeshi_standardarchitecuture.viewmodel

import com.example.amolpardeshi_standardarchitecuture.repo.DummyNewsRepository
import org.junit.Before
import org.junit.Test

class NewsViewModelTest{

    private lateinit var viewModel: NewsViewModel

    @Before
    fun setUp(){
        viewModel = NewsViewModel(DummyNewsRepository())
    }

    @Test
    fun `when sorted correctly in timeCreation order return true`(){

    }

}