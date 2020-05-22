package com.pawan.newsheadlinesapp

import com.pawan.newsheadlinesapp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApp : DaggerApplication() {
    private val applicationInjector = DaggerAppComponent
        .builder()
        .application(this)
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}