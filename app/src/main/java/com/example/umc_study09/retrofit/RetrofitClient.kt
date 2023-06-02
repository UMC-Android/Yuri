package com.example.umc_study09.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val retrofitInterface: RetrofitInterface
    private const val baseUrl = "http://www.kobis.or.kr/"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitInterface = retrofit.create(RetrofitInterface::class.java)
    }

    fun getInstance(): RetrofitClient {
        return this
    }

    fun getRetrofitInterface(): RetrofitInterface {
        return retrofitInterface
    }
}
