package com.example.admin.newsapplication.view.mainActivity

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.admin.newsapplication.R
import com.example.admin.newsapplication.model.Model
import kotlinx.android.synthetic.main.list_item.view.*
import java.util.ArrayList

class MyItemListAdapter(private val articleList: ArrayList<Model.Article>):
        RecyclerView.Adapter<MyItemListAdapter.MyViewHolder>() {

    private val TAG = "MyItemListAdapter"

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val article = articleList[position]
        holder.bindArticle(article)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflatedView = parent.inflate(R.layout.list_item, false)
        return MyViewHolder(inflatedView)
    }

    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var article: Model.Article? = null;

        init {
            v.setOnClickListener(this)
        }

        fun bindArticle(article: Model.Article) {
            this.article = article

            view.tvTitle.text = article.title
            view.tvSource.text = article.source.name
            view.tvAuthor.text = article.author
        }

        override fun onClick(p0: View?) {
            Log.d("MyItemListAdapter", "clicked on " + article?.title)

            val context = itemView.context
//            val showPhotoIntent = Intent(context, PhotoActivity::class.java)
//            showPhotoIntent.putExtra("article", article)
//            context.startActivity(showPhotoIntent)
        }
    }

}