package com.example.admin.newsapplication.view.newsDetailsActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.admin.newsapplication.R
import com.example.admin.newsapplication.model.Model
import com.example.admin.newsapplication.viewModel.ViewModel
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {

    private val TAG = "NewsDetailActivity"
    private var viewModel = ViewModel()
    private lateinit var article: Model.Article

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        article = intent.getParcelableExtra<Model.Article>("article")

        tvSourceID.text = article.source.id
        tvSourceName.text = article.source.name
        tvAuthorName.text = article.author
        tvArticleTitle.text = article.title
        tvDescription.text = article.description
        tvUrl.text = article.url
        tvPublishedAt.text = article.publishedAt

        viewModel.initDatabase(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_details, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        if(isFavorited(article))
            menu.findItem(R.id.mFavorite).setIcon(R.drawable.ic_star_filled_24dp)
        return super.onPrepareOptionsMenu(menu)
    }

    private fun isFavorited(article: Model.Article): Boolean {
        return viewModel.isFavorited(article)
    }

    fun buttonClicked(mi: MenuItem) {
        Log.d(TAG, "Star Clicked")

        //check if it is in the favorites
        if(!isFavorited(article)) {
            if(viewModel.addToFavorites(article))
                mi.setIcon(R.drawable.ic_star_filled_24dp)
        }
    }
}
