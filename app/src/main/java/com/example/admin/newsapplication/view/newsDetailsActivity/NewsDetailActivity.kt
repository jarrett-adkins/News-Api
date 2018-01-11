package com.example.admin.newsapplication.view.newsDetailsActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.admin.newsapplication.R
import com.example.admin.newsapplication.model.Model
import com.example.admin.newsapplication.viewModel.ViewModel
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {

    private val TAG = "NewsDetailActivity"
    private var viewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val article = intent.getParcelableExtra<Model.Article>("article")
//        val article: Model.Article = intent.getSerializableExtra("article") as Model.Article

        tvSourceID.text = article.source.id
        tvSourceName.text = article.source.name
        tvAuthorName.text = article.author
        tvArticleTitle.text = article.title
        tvDescription.text = article.description
        tvUrl.text = article.url
        tvPublishedAt.text = article.publishedAt

    }
}
