package com.anri.exampleapp.data

import com.anri.exampleapp.data.rest.ApiService
import com.anri.exampleapp.data.model.ResponseInfo
import com.anri.exampleapp.data.model.CharacterResult
import com.anri.exampleapp.domain.repositories.CharacterRepo
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val apiService: ApiService
) : CharacterRepo {

    override fun getCharacterDetails(id: Int): Single<CharacterResult> =
        apiService.getCharacterDetails(id).subscribeOn(Schedulers.io())

    override fun getCharacters(page: Int): Single<ResponseInfo<CharacterResult>> =
        apiService.getCharacters(page).subscribeOn(Schedulers.io())
}

