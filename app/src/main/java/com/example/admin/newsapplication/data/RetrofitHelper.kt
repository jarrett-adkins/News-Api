package com.example.admin.newsapplication.data

import com.example.admin.newsapplication.model.Model
import com.example.admin.newsapplication.utils.Constants
import com.example.admin.newsapplication.utils.Constants.BASE_URL
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitHelper{
    @GET("top-headlines?sources=bbc-news&apiKey=" + Constants.API_KEY)
    fun headlines() : Observable<Model.Response>
    // https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=API_KEY
    // https://newsapi.org/v2/everything?page=1&language=en&q=trump&apiKey=API_KEY

    companion object Factory {
        private fun create(): Retrofit {
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit
        }

        fun searchTopHeadlines(): io.reactivex.Observable<Model.Response> {
            val retrofit = create()
            val apiService = retrofit.create(RetrofitHelper::class.java)
            return apiService.headlines()
        }
    }
}