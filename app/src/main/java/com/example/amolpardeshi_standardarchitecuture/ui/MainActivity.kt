package com.example.amolpardeshi_standardarchitecuture.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amolpardeshi_standardarchitecuture.NewsApp
import com.example.amolpardeshi_standardarchitecuture.R
import com.example.amolpardeshi_standardarchitecuture.databinding.ActivityMainBinding
import com.example.amolpardeshi_standardarchitecuture.viewmodel.NewsViewModel
import com.example.amolpardeshi_standardarchitecuture.viewmodel.MainViewModelFactory
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsViewModel: NewsViewModel

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

        (application as NewsApp).applicationComponent.inject(this)
        newsViewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.news_sorting_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.recent -> {
                newsViewModel.sortByRecent()
            }
            R.id.popular -> {
                newsViewModel.sortByPopular()
            }
            else -> super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initUI() {
        val mActionBar: androidx.appcompat.app.ActionBar? = supportActionBar
        mActionBar?.let {
            it.setDisplayShowCustomEnabled(false)
            it.setIcon(R.drawable.ic_menu_icon)
            it.setDisplayShowCustomEnabled(true)
            it.setCustomView(R.layout.custom_actionbar_layout)
        }
        setRecycler()
        setObservers()
    }

    private fun setRecycler() {
        newsAdapter = NewsAdapter()
        binding.rvNewsCards.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun setObservers() {
        newsViewModel.getData()
        newsViewModel.newsLiveData.observe(this) {
            it?.let { data ->
                newsAdapter.newsDataList = data
                newsAdapter.notifyDataSetChanged()
            }
        }
    }
}