package com.anri.exampleapp.data.model

import com.google.gson.annotations.SerializedName

data class ResponseInfo<T>(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<T>
)
