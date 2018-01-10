package com.example.admin.newsapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

// Data classes in Kotlin are classes that are designed specifically for classes that do nothing but
// hold data. The compiler automatically implements 'equals()', 'hashCode()' and 'toString()'.

object Model {
    data class Response(
            @SerializedName("status") @Expose val status: String,
            @SerializedName("totalResults") @Expose val totalResults: Int,
            @SerializedName("articles") @Expose val articles: List<Article> //List<Article> articles
    )

    data class Article(
            @SerializedName("source") @Expose val source: Source,
            @SerializedName("author") @Expose val author: String,
            @SerializedName("title") @Expose val title: String,
            @SerializedName("description") @Expose val description: String,
            @SerializedName("url") @Expose val url: String,
            @SerializedName("urlToImage") @Expose val urlToImage: String,
            @SerializedName("publishedAt") @Expose val publishedAt: String
    )

    data class Source(
            @SerializedName("id") @Expose val id: String,
            @SerializedName("name") @Expose val name: String
    )
}