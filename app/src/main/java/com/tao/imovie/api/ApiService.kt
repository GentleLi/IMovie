package com.tao.imovie.api

import com.tao.imovie.data.UserProfile
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{user}")
    suspend fun getUser(@Path("user") user: String): UserProfile


}