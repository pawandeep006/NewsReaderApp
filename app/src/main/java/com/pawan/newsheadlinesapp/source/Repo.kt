package com.pawan.newsheadlinesapp.source

import com.pawan.newsheadlinesapp.source.database.dao.NewsDao
import com.pawan.newsheadlinesapp.source.database.entity.NewsItem
import com.pawan.newsheadlinesapp.source.network.ApiService
import com.pawan.newsheadlinesapp.source.network.model.NewsResponseWrapper
import retrofit2.Response
import javax.inject.Inject

class Repo @Inject internal constructor(
    private val newsDao: NewsDao,
    private val apiService: ApiService
) {

    fun loadOfflineNews(): List<NewsItem> = newsDao.loadNews()

    suspend fun getOnlineNews(page: Int): List<NewsItem>? {

        try {
            val response = fetchNews(page)
            if (!response.isSuccessful)
                return null
            val responseBody = response.body()

            responseBody?.status?.equals("ok", true)?.let {
                if (!it) {
                    return null
                }
            }
            responseBody?.articles?.let {
                return it
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


        return null
    }

    private suspend fun fetchNews(page: Int): Response<NewsResponseWrapper> =
        apiService.getNews(page)

    fun saveNews(items: List<NewsItem>) {
        if (items.isEmpty())
            return

        newsDao.deleteTable()
        for (item in items)
            newsDao.saveNews(item)

    }

}

