package com.anri.exampleapp.domain.repositories

import com.anri.exampleapp.data.model.ResponseInfo
import com.anri.exampleapp.data.model.CharacterResult
import io.reactivex.Single

interface CharacterRepo {

    fun getCharacters(page: Int): Single<ResponseInfo<CharacterResult>>

    fun getCharacterDetails(id: Int): Single<CharacterResult>

}