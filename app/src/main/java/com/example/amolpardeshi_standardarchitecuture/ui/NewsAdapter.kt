package com.example.amolpardeshi_standardarchitecuture.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.amolpardeshi_standardarchitecuture.databinding.NewsItemLayoutBinding
import com.example.amolpardeshi_standardarchitecuture.model.NewsResponseDto
import com.example.amolpardeshi_standardarchitecuture.utils.Utils.getCustomTimeStringFromTimeStamp

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var newsDataList: List<NewsResponseDto> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            NewsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return newsDataList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(newsDataList[position])
    }

    class NewsViewHolder(private val newsItemLayoutBinding: NewsItemLayoutBinding) :
        ViewHolder(newsItemLayoutBinding.root) {
        fun onBind(item: NewsResponseDto) {
            newsItemLayoutBinding.apply {
                txtHeadLine.text = item.title
                txtSubHeadLine.text = item.description
                Glide.with(itemView)
                    .load(item.bannerUrl)
                    .into(imgThumbNail)
                txtPostTime.text = item.timeCreated?.toLong()?.let { getCustomTimeStringFromTimeStamp(itemView.context, it) }
            }
        }
    }
}