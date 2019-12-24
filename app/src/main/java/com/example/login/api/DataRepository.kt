package com.example.login.api

import android.os.Build
import com.example.login.APIEndPoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataRepository{
    fun create(): PostService {
        var builder = OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addInterceptor(logging)

        val client = builder.build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(APIEndPoint.SERVER)
            .client(client)
            .build()

        return retrofit.create(PostService::class.java)
    }
}