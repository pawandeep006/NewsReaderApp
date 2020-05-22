package com.pawan.newsheadlinesapp.utils

import android.util.Log

const val CONNECT_TIMEOUT = 60L
const val READ_TIMEOUT = 60L
const val WRITE_TIMEOUT = 60L
const val BASE_URL = "https://newsapi.org/v2/"
const val API_KEY = "fe82b6bd59624909b5f60d925cdda915"

fun String.log() {
    Log.e("TAG", this)
}