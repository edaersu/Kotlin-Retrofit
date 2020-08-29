package com.example.kotlinretrofit

import com.example.kotlinretrofit.Model.User
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderApi {

    // https://jsonplaceholder.typicode.com/   users

    @GET("users")
    fun getUsers(): Call<List<User>>


}

