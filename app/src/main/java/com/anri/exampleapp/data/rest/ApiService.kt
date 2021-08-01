package com.anri.exampleapp.data.rest

import com.anri.exampleapp.data.model.ResponseInfo
import com.anri.exampleapp.data.model.CharacterResult
import com.anri.exampleapp.data.model.EpisodeResult
import com.anri.exampleapp.data.model.LocationResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    fun getCharacters(@Query("page") page: Int): Single<ResponseInfo<CharacterResult>>

    @GET("character/{id}")
    fun getCharacterDetails(@Path("id") id: Int): Single<CharacterResult>

    @GET("location")
    fun getLocations(@Query("page") page: Int): Single<ResponseInfo<LocationResult>>

    @GET("location/{id}")
    fun getLocationDetails(@Path("id") id: Int): Single<LocationResult>

    @GET("episode")
    fun getEpisodes(@Query("page") page: Int): Single<ResponseInfo<EpisodeResult>>

    @GET("episode/{id}")
    fun getEpisodeDetails(@Path("id") id: Int): Single<EpisodeResult>
}