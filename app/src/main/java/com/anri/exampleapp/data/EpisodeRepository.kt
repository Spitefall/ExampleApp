package com.anri.exampleapp.data

import com.anri.exampleapp.data.rest.ApiService
import com.anri.exampleapp.data.model.ResponseInfo
import com.anri.exampleapp.data.model.EpisodeResult
import com.anri.exampleapp.domain.repositories.EpisodeRepo
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class EpisodeRepository @Inject constructor(
    private val apiService: ApiService
) : EpisodeRepo {

    override fun getEpisodeDetails(id: Int): Single<EpisodeResult> =
        apiService.getEpisodeDetails(id).subscribeOn(Schedulers.io())

    override fun getEpisodes(page: Int): Single<ResponseInfo<EpisodeResult>> =
        apiService.getEpisodes(page).subscribeOn(Schedulers.io())
}

