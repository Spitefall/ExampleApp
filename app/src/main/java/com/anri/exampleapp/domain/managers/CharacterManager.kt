package com.anri.exampleapp.domain.managers

import com.anri.exampleapp.domain.repositories.CharacterRepo
import com.anri.exampleapp.domain.model.characters.Character
import io.reactivex.Single
import javax.inject.Inject

class CharacterManager @Inject constructor(private val characterRepo: CharacterRepo) {

    fun getCharacterDetails(id: Int): Single<Character> =
        characterRepo.getCharacterDetails(id).map { Character.from(it) }

    fun getCharacters(page: Int): Single<Pair<Int, List<Character>>> =
        characterRepo.getCharacters(page).map { Pair(it.info.pages ?: 0, Character.from(it.results)) }
}