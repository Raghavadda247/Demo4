package com.example.demo4

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey

const val baseUrl= "https://newsapi.org/"
const val apiKey="c998a444e9e24311ace1a6475070c838"
interface NewsInterface {
    @GET("v2/top-headlines?apiKey=$apiKey")
    fun getHeadlines(@Query("country")country:String,@Query("page") page:Int):Call<News>

}

object NewsService{
    val newsInstance: NewsInterface
    init{
        val retrofit= Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance=retrofit.create(NewsInterface::class.java)
    }
}