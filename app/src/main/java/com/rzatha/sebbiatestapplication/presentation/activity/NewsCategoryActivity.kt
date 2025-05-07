package com.rzatha.sebbiatestapplication.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rzatha.sebbiatestapplication.databinding.ActivityCategoriesBinding
import com.rzatha.sebbiatestapplication.domain.NewsCategory
import com.rzatha.sebbiatestapplication.presentation.adapter.NewsCategoryListAdapter
import com.rzatha.sebbiatestapplication.presentation.viewmodel.NewsCategoryViewModel

class NewsCategoryActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[NewsCategoryViewModel::class.java]
    }

    private val binding by lazy {
        ActivityCategoriesBinding.inflate(layoutInflater)
    }
    private val categoryAdapter = NewsCategoryListAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {

        viewModel.newsCategoryList.observe(this) { categoryList ->
            categoryAdapter.submitList(categoryList)
        }

        categoryAdapter.onCategoryClickListener = object: NewsCategoryListAdapter.OnCategoryClickListener{

            override fun onCategoryClick(category: NewsCategory) {
                // Запуск NewsActivity
            }

        }
    }


}