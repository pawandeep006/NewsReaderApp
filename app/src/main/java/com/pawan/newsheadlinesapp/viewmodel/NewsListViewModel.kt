package com.pawan.newsheadlinesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pawan.newsheadlinesapp.source.Repo
import com.pawan.newsheadlinesapp.source.database.entity.NewsItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class NewsListViewModel @Inject constructor(private val repo: Repo) : ViewModel() {

    private var pageNumber: Int = 1

    init {
        fetchData(pageNumber)
    }

    val newsItems: MutableLiveData<List<NewsItem>> = MutableLiveData()

    private fun fetchNewsFromServer() {
        runBlocking {
            GlobalScope.launch {
                val process = async { repo.getOnlineNews(pageNumber) }
                process.await()?.let {
                    repo.saveNews(it)
                    newsItems.postValue(it)
                } ?: run {
                    newsItems.postValue(repo.loadOfflineNews())
                }

            }
        }
    }

    fun fetchData(page: Int) {
        pageNumber = page
        fetchNewsFromServer()
    }
}