package com.tao.imovie.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tao.imovie.api.ApiTransformer
import com.tao.imovie.data.User
import com.tao.imovie.data.UserProfile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }

    private val userProfile: MutableLiveData<UserProfile> by lazy {
        MutableLiveData<UserProfile>().also {
            loadUserProfile()
        }
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    fun getUserProfile(): LiveData<UserProfile> {
        return userProfile
    }

    private fun loadUserProfile() {
        CoroutineScope(Dispatchers.IO).launch {
            val profile = ApiTransformer.getUserProfile("GentleLi")
            Log.e("profile : ", profile.bio)
            userProfile.postValue(profile)
        }
    }

    private fun loadUsers() {
        // Do an asynchronous operation to fetch users.

    }
}