package com.example.jinotas.api.userApi

import com.google.gson.annotations.SerializedName

data class ApiUser(
    @SerializedName("Id") val id: Int? = null,
    @SerializedName("userName") val userName: String,
    @SerializedName("password") val password: String,
    @SerializedName("token") val token: String


) {
    override fun toString(): String {
        return "ApiUser(id=$id, userName='$userName', password='$password', token='$token')"
    }
}

