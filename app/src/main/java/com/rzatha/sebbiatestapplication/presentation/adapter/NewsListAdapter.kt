package com.rzatha.sebbiatestapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rzatha.sebbiatestapplication.databinding.NewsItemBinding
import com.rzatha.sebbiatestapplication.domain.News
import com.rzatha.sebbiatestapplication.presentation.extensions.formatToUi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NewsListAdapter : ListAdapter<News, NewsListAdapter.NewsViewHolder>(
    NewsItemDiffCallback()
) {
    var onNewsClickListener: OnNewsClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsViewHolder {
        val binding = NewsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NewsViewHolder,
        position: Int
    ) {
        val news = getItem(position)
        with(holder.binding) {
            tvNewsTitle.text = news.title
            tvNewsDescription.text = news.shortDescription
            tvNewsDate.text = news.date.formatToUi()

            root.setOnClickListener {
                onNewsClickListener?.onNewsClick(news)
            }
        }
    }

    class NewsViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root)


    interface OnNewsClickListener {
        fun onNewsClick(news: News)
    }

    private class NewsItemDiffCallback : DiffUtil.ItemCallback<News>() {

        override fun areItemsTheSame(
            oldItem: News,
            newItem: News
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: News,
            newItem: News
        ): Boolean {
            return oldItem == newItem
        }

    }
}