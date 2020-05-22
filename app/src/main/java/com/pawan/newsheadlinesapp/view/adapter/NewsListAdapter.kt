package com.pawan.newsheadlinesapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pawan.newsheadlinesapp.databinding.NewsItemBinding
import com.pawan.newsheadlinesapp.source.database.entity.NewsItem
import java.util.*

class NewsListAdapter(
    private val onClickListener: (NewsItem) -> Unit
) :
    RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    var newsItems: MutableList<NewsItem> = ArrayList<NewsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = newsItems.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = newsItems[position]

        holder.apply {
            bind(View.OnClickListener {
                onClickListener(item)
            }, item)
        }
    }

    fun setData(items: List<NewsItem>) {
        val set: MutableSet<NewsItem> = newsItems.toMutableSet()
        set.addAll(items)

        with(newsItems) {
            clear()
            addAll(set.toList())
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, NewsItem: NewsItem) {
            binding.apply {
                onClick = listener
                item = NewsItem
                executePendingBindings()
            }
        }
    }

}