package com.example.kotlinretrofit.Model

import com.google.gson.annotations.SerializedName

class User(
    var id: String,
    var name: String,
    @SerializedName("email")
    var email_user: String,
    var username: String
)