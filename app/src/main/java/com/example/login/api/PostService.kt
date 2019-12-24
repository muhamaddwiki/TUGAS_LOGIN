package com.example.login.api

import com.example.login.model.ResponseLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PostService {
    @FormUrlEncoded
    @POST("read_user.php")
    fun getLogin(@Field("username") username: String, @Field("password") password: String): Call<ResponseLogin>

    @GET("daftar.php")
    fun getUsers(): Call<ResponseLogin>

}
