package com.pawan.newsheadlinesapp.view.fragment

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.os.bundleOf
import com.pawan.newsheadlinesapp.databinding.FragmentDescriptionNewsBinding
import com.pawan.newsheadlinesapp.source.database.entity.NewsItem
import com.pawan.newsheadlinesapp.view.activity.BaseActivity
import com.pawan.newsheadlinesapp.viewmodel.NewsDescriptionViewModel
import kotlinx.android.synthetic.main.fragment_description_news.*


class NewsDescriptionFragment : BaseFragment<NewsDescriptionViewModel>() {

    private var newsItem: NewsItem? = null
    private lateinit var binding: FragmentDescriptionNewsBinding

    companion object {
        fun get(item: NewsItem): NewsDescriptionFragment {
            val fragment = NewsDescriptionFragment()
            fragment.arguments = bundleOf(
                Pair("data", item)
            )
            return fragment
        }

    }

    override fun getViewModel(): Class<NewsDescriptionViewModel> =
        NewsDescriptionViewModel::class.java


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDescriptionNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            newsItem = it.getParcelable("data")
        }
        newsItem?.let {
            binding.data = it
        } ?: kotlin.run {
            activity?.onBackPressed()
        }

        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                binding.isLoading = true
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                binding.isLoading = false
                super.onPageFinished(view, url)
            }

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as BaseActivity).supportActionBar?.hide()
    }

    override fun onDetach() {
        super.onDetach()
        (activity as BaseActivity).supportActionBar?.show()
    }

}
