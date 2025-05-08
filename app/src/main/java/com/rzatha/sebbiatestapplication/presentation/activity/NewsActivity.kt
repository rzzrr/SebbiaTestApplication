package com.rzatha.sebbiatestapplication.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rzatha.sebbiatestapplication.R
import com.rzatha.sebbiatestapplication.databinding.ActivityNewsBinding
import com.rzatha.sebbiatestapplication.domain.News
import com.rzatha.sebbiatestapplication.domain.NewsCategory
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
    private val category by lazy {
        getCategoryExtra()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        observeViewModel()
        bindViews()
        viewModel.loadNewsByCategory(category.id)
    }

    private fun observeViewModel() {
        with(viewModel) {
            currentPage.observe(this@NewsActivity) {
                binding.tvPageCount.text =
                    "${getString(R.string.page)}: $it"
            }

            newsList.observe(this@NewsActivity) { newsList ->
                adapter.submitList(newsList)
            }
        }
    }

    private fun bindViews() {
        with(binding) {
            tvNewsActivityTitle.text =
                "${getString(R.string.category)}: ${category.name}"

            ivNextPage.setOnClickListener {
                viewModel.increasePage(category.id)
            }
            ivPrevPage.setOnClickListener {
                viewModel.decreasePage(category.id)
            }
        }
    }

    private fun getCategoryExtra() : NewsCategory {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(EXTRA_CATEGORY, NewsCategory::class.java).also {
                return it?: throw IllegalArgumentException("required NewsCategory is null")
            }
        } else {
            return  intent.getSerializableExtra(EXTRA_CATEGORY) as NewsCategory
        }
    }


    private fun setupRecyclerView() {
        binding.rvNews.adapter = adapter

        adapter.onNewsClickListener = object : NewsListAdapter.OnNewsClickListener {
            override fun onNewsClick(news: News) {
                //start news detail activity
            }
        }
    }

    companion object {

        private const val EXTRA_CATEGORY = "extra_category"

        fun newIntent(context: Context, category: NewsCategory): Intent {
            return Intent(context, NewsActivity::class.java).apply {
                putExtra(EXTRA_CATEGORY, category)
            }
        }
    }
}