package com.rzatha.sebbiatestapplication.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rzatha.sebbiatestapplication.R
import com.rzatha.sebbiatestapplication.databinding.ActivityCategoriesBinding

class CategoriesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCategoriesBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }



}