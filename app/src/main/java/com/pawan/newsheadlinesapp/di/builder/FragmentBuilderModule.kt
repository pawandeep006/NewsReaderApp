package com.pawan.newsheadlinesapp.di.builder

import com.pawan.newsheadlinesapp.view.fragment.NewsDescriptionFragment
import com.pawan.newsheadlinesapp.view.fragment.NewsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {
    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract fun contributeNewsListFragment(): NewsListFragment

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract fun contributeNewsDescriptionFragment(): NewsDescriptionFragment
}