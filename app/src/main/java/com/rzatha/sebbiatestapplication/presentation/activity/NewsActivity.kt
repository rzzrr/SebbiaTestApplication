package com.rzatha.sebbiatestapplication.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rzatha.sebbiatestapplication.databinding.ActivityNewsBinding
import com.rzatha.sebbiatestapplication.domain.News
import com.rzatha.sebbiatestapplication.presentation.adapter.NewsListAdapter
import com.rzatha.sebbiatestapplication.presentation.viewmodel.NewsViewModel

class NewsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityNewsBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        ViewModelProvider(this)[NewsViewModel::class.java]
    }

    private val adapter = NewsListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        intent.getIntExtra(EXTRA_CATEGORY_ID, -1).also {
            if (it!= -1) {
                viewModel.loadNewsByCategory(it)
            }
        }

    }


    private fun setupRecyclerView() {
        binding.rvNews.adapter = adapter

        viewModel.newsList.observe(this) { newsList ->
            adapter.submitList(newsList)
        }

        adapter.onNewsClickListener = object : NewsListAdapter.OnNewsClickListener{
            override fun onNewsClick(news: News) {
                //start news detail activity
            }
        }
    }

    companion object {

        private const val EXTRA_CATEGORY_ID = "extra_category_id"

        fun newIntent(context: Context, categoryId: Int): Intent {
            return Intent(context, NewsActivity::class.java).apply {
                putExtra(EXTRA_CATEGORY_ID, categoryId)
            }
        }
    }
}