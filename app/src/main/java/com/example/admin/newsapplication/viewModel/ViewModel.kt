package com.example.admin.newsapplication.viewModel

import android.util.Log
import com.example.admin.newsapplication.data.RetrofitHelper
import com.example.admin.newsapplication.model.Model
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.Observable
import java.util.*

class ViewModel {
// It should not know, for example, is the data coming from a database or a remote server

//    fun getHeadLines() {
//        var articleList: ArrayList<Model.Article> = ArrayList()
//
//        RetrofitHelper.searchTopHeadlines()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe ({
//                    result ->
//                    Log.d("Result", "There are ${result.articles.size} results")
//
//                    for( a in result.articles )
//                        articleList.add(a)
//
//                    // call initRecyclerView, pass articleList
//                }, { error ->
//                    error.printStackTrace()
//                })
//
//        Log.d("getHeadlines", "" +  articleList.size)
//    }

    fun getHeadlines(): Observable<Model.Response> {
        return RetrofitHelper.searchTopHeadlines()
    }
}