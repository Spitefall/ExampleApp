package com.anri.exampleapp.data.model

import com.google.gson.annotations.SerializedName

data class CharacterResult(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val originResult: OriginResult,
    @SerializedName("location")
    val location: LocationResult,
    @SerializedName("image")
    val image: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
)
