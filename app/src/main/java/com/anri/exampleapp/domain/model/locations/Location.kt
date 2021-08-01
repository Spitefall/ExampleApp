package com.anri.exampleapp.domain.model.locations

import com.anri.exampleapp.data.model.LocationResult
import com.anri.exampleapp.domain.model.PostModel

data class Location(
    val id: Int?,
    val name: String?,
    val type: String?,
    val dimension: String?
): PostModel {
    companion object {
        fun from(model: LocationResult) = Location(model.id, model.name, model.type, model.dimension)
        fun from(list: List<LocationResult>) = list.map { from(it) }
    }
}