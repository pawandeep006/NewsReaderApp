package com.pawan.newsheadlinesapp.view.activity

import android.os.Bundle
import com.pawan.newsheadlinesapp.R
import com.pawan.newsheadlinesapp.source.database.entity.NewsItem
import com.pawan.newsheadlinesapp.view.fragment.NewsDescriptionFragment
import com.pawan.newsheadlinesapp.view.fragment.NewsListFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override val layoutRes: Int
        get() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadListFragment()
    }

    private fun loadListFragment() {
        supportActionBar?.title = "Latest News Headlines"
        replaceFragment(container, NewsListFragment.get())
    }


    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount

        if (count == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    fun loadDescriptionFragment(item: NewsItem) {
        addFragment(container, NewsDescriptionFragment.get(item))
    }
}
