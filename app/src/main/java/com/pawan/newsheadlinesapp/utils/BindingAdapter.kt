package com.pawan.newsheadlinesapp.utils

import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BindingAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String) {
            Glide.with(view.context).load(url).apply(RequestOptions().centerCrop()).into(view)
        }

        @JvmStatic
        @BindingAdapter("loadUrl")
        fun loadUrl(view: WebView, url: String) {
            view.loadUrl(url)
        }
    }
}