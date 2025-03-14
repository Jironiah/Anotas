package com.example.jinotas.api.notesApi

import com.google.gson.annotations.SerializedName

data class ApiNote(
    @SerializedName("Id") val id: Int,

    @SerializedName("code") val code: Int,

    @SerializedName("title") val title: String,

    @SerializedName("textContent") val textContent: String,

    @SerializedName("date") val date: String,

    @SerializedName("userFrom") var userFrom: String,

    @SerializedName("userTo") var userTo: String,

    @SerializedName("updatedTime") var updatedTime: Long,

    @SerializedName("CreatedAt") val createdAt: String? = null,

    @SerializedName("UpdatedAt") val updatedAt: String? = null
)
