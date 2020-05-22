package com.pawan.newsheadlinesapp.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pawan.newsheadlinesapp.databinding.FragmentListNewsBinding
import com.pawan.newsheadlinesapp.utils.EndlessRecyclerViewScrollListener
import com.pawan.newsheadlinesapp.view.activity.MainActivity
import com.pawan.newsheadlinesapp.view.adapter.NewsListAdapter
import com.pawan.newsheadlinesapp.viewmodel.NewsListViewModel

class NewsListFragment : BaseFragment<NewsListViewModel>() {
    companion object {
        fun get(): NewsListFragment = NewsListFragment()
    }

    private lateinit var binding: FragmentListNewsBinding

    override fun getViewModel(): Class<NewsListViewModel> = NewsListViewModel::class.java

    private lateinit var adapter: NewsListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListNewsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
        binding.isLoading = true
        binding.isLoadMore = false
        viewModel?.newsItems?.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
            binding.isLoading = false
            binding.isLoadMore = false
        })
    }

    private fun setupList() {
        adapter = NewsListAdapter() { item ->
            (activity as MainActivity).loadDescriptionFragment(item)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)

            val endlessListener =
                object : EndlessRecyclerViewScrollListener(layoutManager as LinearLayoutManager) {
                    override fun onLoadMore(page: Int, totalItemsCount: Int) {
                        binding.isLoadMore = true
                        viewModel?.fetchData(page + 1)
                    }

                }
            addOnScrollListener(endlessListener)
        }
    }
}
