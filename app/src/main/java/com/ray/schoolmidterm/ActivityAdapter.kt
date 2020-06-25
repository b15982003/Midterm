package com.ray.schoolmidterm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ray.schoolmidterm.data.PostData
import com.ray.schoolmidterm.databinding.ItemActivityMainRecyBinding


class ActivityAdapter : ListAdapter<PostData, ActivityAdapter.ActivityViewModelHolder>(DiffCallback) {


    class ActivityViewModelHolder(private var binding: ItemActivityMainRecyBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(postData: PostData ) {
            binding.viewModel = postData

            binding.executePendingBindings()
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [MarsProperty]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<PostData>() {
        override fun areItemsTheSame(oldItem: PostData, newItem: PostData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PostData, newItem: PostData): Boolean {
            return oldItem == newItem
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewModelHolder{
        return ActivityViewModelHolder(ItemActivityMainRecyBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ActivityViewModelHolder, position: Int) {
        val postData = getItem(position)
        holder.bind(postData)
    }
}


