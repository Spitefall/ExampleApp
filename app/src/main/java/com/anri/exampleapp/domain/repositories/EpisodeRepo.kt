package com.anri.exampleapp.domain.repositories

import com.anri.exampleapp.data.model.ResponseInfo
import com.anri.exampleapp.data.model.EpisodeResult
import io.reactivex.Single

interface EpisodeRepo {

    fun getEpisodes(page: Int): Single<ResponseInfo<EpisodeResult>>

    fun getEpisodeDetails(id: Int): Single<EpisodeResult>
}