package com.example.demo4

import com.example.demo4.data.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey

const val baseUrl= "https://newsapi.org/"
const val apiKey="c998a444e9e24311ace1a6475070c838"
interface NewsInterface {
    @GET("v2/top-headlines?apiKey=$apiKey")
    fun getHeadlines(@Query("country") country: String, @Query("page") page: Int): Call<News>
}