package com.tao.imovie.api

import com.tao.imovie.data.UserProfile

object ApiTransformer {
    suspend fun getUserProfile(user: String): UserProfile {
        val retrofit = RetrofitFactory.retrofit
        val apiService = retrofit.create(ApiService::class.java)
        return apiService.getUser(user)
    }
}