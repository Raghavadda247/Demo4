package com.example.demo4.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.demo4.NewsInterface
import com.example.demo4.data.model.News
import com.example.demo4.data.model.retrofit.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewViewModel : ViewModel() {
    lateinit var newsList:MutableLiveData<News>

    init {
        newsList= MutableLiveData()
    }

    fun getObserver():MutableLiveData<News>{
        return newsList
    }

    fun fetchNews(){
        val retroInstance=RetroInstance.getInstance()
        val retroService= retroInstance.create(NewsInterface::class.java)
        val call= retroService.getHeadlines("in",1)
        call.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                newsList.postValue(response.body())
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                newsList.postValue(null)
            }

        })
    }


}











