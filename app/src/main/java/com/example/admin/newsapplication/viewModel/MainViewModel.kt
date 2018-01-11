package com.example.admin.newsapplication.viewModel

import com.example.admin.newsapplication.model.Model
import com.example.admin.newsapplication.utils.Constants
import io.reactivex.Observable
import retrofit2.http.GET

class MainViewModel(val headlineRepository: HeadlineRepository) {

    fun getHeadlines(): Observable<Model.Response> {
        //Prepare the data for your UI, the users list
        //and maybe some additional data needed as well
        return headlineRepository.getHeadlines()
    }
}

class HeadlineRepository(val newsApi: NewsApi) {

    fun getHeadlines(): Observable<Model.Response> {
        return newsApi.getHeadlines()
    }
}

interface NewsApi {
    @GET("top-headlines?language=en&apiKey=" + Constants.API_KEY)
    fun getHeadlines() : Observable<Model.Response>
}