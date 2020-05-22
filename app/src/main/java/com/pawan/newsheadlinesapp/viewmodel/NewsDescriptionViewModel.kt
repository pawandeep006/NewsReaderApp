package com.pawan.newsheadlinesapp.viewmodel

import androidx.lifecycle.ViewModel
import com.pawan.newsheadlinesapp.source.Repo
import javax.inject.Inject

class NewsDescriptionViewModel @Inject constructor(private val repo: Repo) : ViewModel() {

}
