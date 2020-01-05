package com.example.numbers_kotlin

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.os.AsyncTask.execute




class NumbersApi {
    companion object {
        private const val baseUrl = "http://numbersapi.com/"

        var client = OkHttpClient()

        fun createApi(): NumbersApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            val numbersApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return numbersApi.create(NumbersApiService::class.java)
        }
    }
}
