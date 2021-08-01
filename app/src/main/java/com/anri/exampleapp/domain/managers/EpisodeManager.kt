package com.anri.exampleapp.domain.managers

import com.anri.exampleapp.domain.repositories.EpisodeRepo
import com.anri.exampleapp.domain.model.episodes.Episode
import io.reactivex.Single
import javax.inject.Inject

class EpisodeManager @Inject constructor(private val episodeRepo: EpisodeRepo) {

    fun getEpisodeDetails(id: Int): Single<Episode>? =
        episodeRepo.getEpisodeDetails(id).map { Episode.from(it) }

    fun getEpisodes(page: Int): Single<Pair<Int, List<Episode>>> =
        episodeRepo.getEpisodes(page).map { Pair(it.info.pages ?: 0, Episode.from(it.results)) }
}