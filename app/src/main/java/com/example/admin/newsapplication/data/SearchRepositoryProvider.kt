//package com.example.admin.newsapplication.data
//
//import com.example.admin.newsapplication.model.Model
//
//object SearchRepositoryProvider {
//    fun provideSearchRepository(): SearchRepository {
//        return SearchRepository(RetrofitHelper.Factory.create())
//    }
//}
//
//class SearchRepository(val apiService: RetrofitHelper) {
//
//    fun searchHeadLines(): io.reactivex.Observable<Model.Response> {
//        return apiService.searchTopHeadlines()
//    }
//}