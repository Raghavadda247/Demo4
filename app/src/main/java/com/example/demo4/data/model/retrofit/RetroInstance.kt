package com.example.demo4.data.model.retrofit

import com.example.demo4.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    companion object {
        fun getInstance(): Retrofit {
                 return Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }
}