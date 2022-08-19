package com.example.demo4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.demo4.NewsInterface
import com.example.demo4.data.model.Article
import com.example.demo4.data.model.News
import com.example.demo4.data.model.retrofit.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewViewModel : ViewModel() {
    lateinit var newsList:MutableLiveData<List<Article>>

    init {
        newsList= MutableLiveData()
    }

    fun getObserver():MutableLiveData<List<Article>>{
        return newsList
    }

    fun fetchNews(){
        val retroInstance=RetroInstance.getInstance()
        val retroService= retroInstance.create(NewsInterface::class.java)
        val call= retroService.getHeadlines("in",1)
        call.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                newsList.postValue(response.body()?.articles)
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                newsList.postValue(null)
            }

        })
    }


}












