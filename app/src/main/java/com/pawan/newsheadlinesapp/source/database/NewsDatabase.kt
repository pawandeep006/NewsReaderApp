package com.pawan.newsheadlinesapp.source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pawan.newsheadlinesapp.source.database.dao.NewsDao
import com.pawan.newsheadlinesapp.source.database.entity.NewsItem

@Database(entities = [NewsItem::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}