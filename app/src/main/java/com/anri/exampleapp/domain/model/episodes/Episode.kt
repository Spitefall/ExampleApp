package com.anri.exampleapp.domain.model.episodes

import com.anri.exampleapp.data.model.EpisodeResult
import com.anri.exampleapp.domain.model.PostModel

data class Episode(
    var id: Int,
    val name: String,
    var airDate: String,
    var episode: String,
): PostModel {
    companion object {
        fun from(model: EpisodeResult) = Episode(model.id, model.name, model.airDate, model.episode)
        fun from(list: List<EpisodeResult>) = list.map { from(it) }
    }
}