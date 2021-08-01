package com.anri.exampleapp.data.model

import com.google.gson.annotations.SerializedName

data class OriginResult(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String)