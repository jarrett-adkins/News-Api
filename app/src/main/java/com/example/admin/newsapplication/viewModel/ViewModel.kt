package com.example.admin.newsapplication.viewModel

import android.content.Context
import com.example.admin.newsapplication.data.local.DatabaseHelper
import com.example.admin.newsapplication.data.remote.RetrofitHelper
import com.example.admin.newsapplication.model.Model
import io.reactivex.Observable
import kotlin.properties.Delegates

class ViewModel {

    var dbHelper: DatabaseHelper by Delegates.notNull()

    fun getHeadlines(): Observable<Model.Response> {
        return RetrofitHelper.searchTopHeadlines()
    }

    fun initDatabase(context: Context) {
        dbHelper = DatabaseHelper(context)
    }

    fun isFavorited(article: Model.Article): Boolean {
        return dbHelper.checkIfFavorited(article)
    }

    fun addToFavorites(article: Model.Article): Boolean {
        var l = dbHelper.addToFavorites(article)
        return ( l > -1 )
    }
}
// make context a field injection with dagger
/*
Try these
https://medium.com/@manuelvicnt/rxjava-android-mvvm-app-structure-with-retrofit-a5605fa32c00
Retrofit layer is like my RetrofitHelper interface.

The API service calls the Retrofit Layer and processes the response, returning an
Observable<ResponseObject>. It does the on subscribe and on error stuff. Seems to cover what the
displayHeadlines() does.

https://proandroiddev.com/modern-android-development-with-kotlin-september-2017-part-2-17444fcdbe86
 */