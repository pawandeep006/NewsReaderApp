package com.pawan.newsheadlinesapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pawan.newsheadlinesapp.viewmodel.NewsDescriptionViewModel
import com.pawan.newsheadlinesapp.viewmodel.NewsListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel::class)
    abstract fun bindFNewsListViewModel(fragmentViewModel: NewsListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewsDescriptionViewModel::class)
    abstract fun bindNewsDescriptionViewModel(fragmentViewModel: NewsDescriptionViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}

@MustBeDocumented
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)