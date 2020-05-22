package com.pawan.newsheadlinesapp.source.database.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "news_items")
data class NewsItem(

    @PrimaryKey
    @SerializedName("url")
    @Expose
    var url: String = "",

    @SerializedName("author")
    @Expose
    var author: String? = "",

    @SerializedName("title")
    @Expose
    var title: String? = "",

    @SerializedName("description")
    @Expose
    var description: String? = "",

    @SerializedName("urlToImage")
    @Expose
    var urlToImage: String? = "",

    @SerializedName("publishedAt")
    @Expose
    var publishedAt: String? = "",

    @SerializedName("content")
    @Expose
    var content: String? = ""

) : Parcelable