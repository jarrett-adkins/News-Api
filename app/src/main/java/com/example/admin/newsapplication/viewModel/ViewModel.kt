package com.example.admin.newsapplication.viewModel

import com.example.admin.newsapplication.data.RetrofitHelper
import com.example.admin.newsapplication.model.Model
import io.reactivex.Observable

class ViewModel {
    fun getHeadlines(): Observable<Model.Response> {
        return RetrofitHelper.searchTopHeadlines()
    }
}