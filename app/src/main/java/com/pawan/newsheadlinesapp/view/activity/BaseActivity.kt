package com.pawan.newsheadlinesapp.view.activity

import android.os.Bundle
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.pawan.newsheadlinesapp.view.fragment.BaseFragment
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity : DaggerAppCompatActivity() {

    @get:LayoutRes
    protected abstract val layoutRes: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
    }

    fun addFragment(container: FrameLayout, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(fragment.javaClass.canonicalName)
            .add(container.id, fragment, fragment.javaClass.canonicalName)
            .commit()
    }

    fun replaceFragment(container: FrameLayout, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(fragment.javaClass.canonicalName)
            .replace(container.id, fragment, fragment.javaClass.canonicalName)
            .commit()
    }

    fun popBackStack() {
        val fragments =
            supportFragmentManager.fragments
        for (f in fragments) {
            if (f != null && f is BaseFragment<*>) {
                supportFragmentManager.popBackStack()
                break
            }
        }
    }
}