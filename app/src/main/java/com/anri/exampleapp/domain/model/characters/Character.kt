package com.anri.exampleapp.domain.model.characters

import com.anri.exampleapp.data.model.CharacterResult
import com.anri.exampleapp.domain.model.PostModel
import com.anri.exampleapp.domain.model.locations.Location

data class Character(
    val id: Int?,
    val name: String?,
    val species: String?,
    val status: String?,
    val gender: String?,
    val imageUrl: String?,
    val location: Location?
): PostModel {
    companion object {
        fun from(model: CharacterResult) = Character(model.id, model.name, model.species, model.status, model.gender, model.image, Location.from(model.location))
        fun from(list: List<CharacterResult>) = list.map { from(it) }
    }
}