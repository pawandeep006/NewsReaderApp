package com.pawan.newsheadlinesapp.source.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pawan.newsheadlinesapp.source.database.entity.NewsItem

@Dao
interface NewsDao {
    @Query("SELECT * FROM news_items")
    fun loadNews(): List<NewsItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNews(items: NewsItem)

    @Query("DELETE FROM news_items")
    fun deleteTable()
}