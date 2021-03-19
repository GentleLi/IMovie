package com.tao.imovie.api

import com.tao.imovie.data.News
import com.tao.imovie.data.UserProfile
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users/{user}")
    suspend fun getUser(@Path("user") user: String): UserProfile

    @GET()
    suspend fun getNewsList(@Query("page") page: Int): List<News>

}