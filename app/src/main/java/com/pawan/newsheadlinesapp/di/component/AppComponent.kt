package com.pawan.newsheadlinesapp.di.component

import android.app.Application
import com.pawan.newsheadlinesapp.BaseApp
import com.pawan.newsheadlinesapp.di.builder.ActivityBuilderModule
import com.pawan.newsheadlinesapp.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class
    ]
)
interface AppComponent : AndroidInjector<BaseApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(app: BaseApp)
}