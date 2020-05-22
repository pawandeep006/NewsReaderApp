package com.pawan.newsheadlinesapp.source.network

import com.pawan.newsheadlinesapp.source.network.model.NewsResponseWrapper
import com.pawan.newsheadlinesapp.utils.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines?country=us&apiKey=$API_KEY")
    suspend fun getNews(@Query("page") page: Int): Response<NewsResponseWrapper>
}