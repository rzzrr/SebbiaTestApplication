package com.rzatha.sebbiatestapplication.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rzatha.sebbiatestapplication.databinding.CategoryItemBinding
import com.rzatha.sebbiatestapplication.domain.NewsCategory

class NewsCategoryListAdapter : ListAdapter<NewsCategory, NewsCategoryListAdapter.NewsCategoryViewHolder>(
    NewsCategoryItemDiffCallback()
) {
    var onCategoryClickListener: OnCategoryClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsCategoryViewHolder {
        val binding = CategoryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: NewsCategoryViewHolder,
        position: Int
    ) {
        val category = getItem(position)
        with(holder.binding){
            tvCategoryName.text = category.name

            root.setOnClickListener {
                onCategoryClickListener?.onCategoryClick(category)
            }
        }
    }

    class NewsCategoryViewHolder(val binding: CategoryItemBinding)
        : RecyclerView.ViewHolder(binding.root)


    interface OnCategoryClickListener{
        fun onCategoryClick(category: NewsCategory)
    }

    private class NewsCategoryItemDiffCallback: DiffUtil.ItemCallback<NewsCategory>() {

        override fun areItemsTheSame(
            oldItem: NewsCategory,
            newItem: NewsCategory
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: NewsCategory,
            newItem: NewsCategory
        ): Boolean {
            return oldItem == newItem
        }

    }
}