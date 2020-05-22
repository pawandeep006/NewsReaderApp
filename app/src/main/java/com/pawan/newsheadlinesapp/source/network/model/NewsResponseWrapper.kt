package com.pawan.newsheadlinesapp.source.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.pawan.newsheadlinesapp.source.database.entity.NewsItem

class NewsResponseWrapper {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("totalResults")
    @Expose
    var totalResults: Long = 0

    @SerializedName("articles")
    @Expose
    var articles: List<NewsItem>? = null

}