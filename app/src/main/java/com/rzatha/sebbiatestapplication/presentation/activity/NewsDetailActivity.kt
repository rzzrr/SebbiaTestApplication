package com.rzatha.sebbiatestapplication.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rzatha.sebbiatestapplication.databinding.ActivityNewsDetailBinding
import com.rzatha.sebbiatestapplication.domain.News
import com.rzatha.sebbiatestapplication.presentation.extensions.formatToUi
import com.rzatha.sebbiatestapplication.presentation.viewmodel.NewsDetailViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NewsDetailActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[NewsDetailViewModel::class.java]
    }

    private val binding by lazy {
        ActivityNewsDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observeViewModel()
        intent.getIntExtra(EXTRA_ID, DEFAULT_ID).also {
            if (it != DEFAULT_ID) {
                viewModel.loadNewsDetail(it)
            }
        }
    }

    private fun observeViewModel() {
        viewModel.news.observe(this) {
            bindViews(it)
        }
    }

    private fun bindViews(news: News) {
        with(binding) {
            tvNewsTitle.text = news.title
            tvNewsDate.text = news.date.formatToUi()
            tvNewsShortDescription.text = news.shortDescription
            tvNewsFullDescription.text =
                Html.fromHtml(news.fullDescription, Html.FROM_HTML_MODE_COMPACT)
            tvNewsFullDescription.movementMethod = LinkMovementMethod.getInstance()
        }
    }



    companion object {
        private const val EXTRA_ID = "id"
        private const val DEFAULT_ID = -1
        fun newIntent(context: Context, newsId: Int): Intent {
            return Intent(context, NewsDetailActivity::class.java).also {
                it.putExtra(EXTRA_ID, newsId)
            }
        }
    }
}