package com.example.admin.newsapplication.viewModel

import com.example.admin.newsapplication.data.RetrofitHelper
import com.example.admin.newsapplication.model.Model
import io.reactivex.Observable

class ViewModel {

    fun getHeadlines(): Observable<Model.Response> {
        return RetrofitHelper.searchTopHeadlines()
    }
}

/*
Try these
https://medium.com/@manuelvicnt/rxjava-android-mvvm-app-structure-with-retrofit-a5605fa32c00
Retrofit layer is like my RetrofitHelper interface.

The API service calls the Retrofit Layer and processes the response, returning an
Observable<ResponseObject>. It does the on subscribe and on error stuff. Seems to cover what the
displayHeadlines() does.

https://proandroiddev.com/modern-android-development-with-kotlin-september-2017-part-2-17444fcdbe86
 */