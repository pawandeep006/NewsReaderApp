package com.pawan.newsheadlinesapp.view.fragment

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<V : ViewModel?> : DaggerFragment() {

    var viewModel: V? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract fun getViewModel(): Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(getViewModel())
    }
}