package com.anri.exampleapp.domain.repositories

import com.anri.exampleapp.data.model.ResponseInfo
import com.anri.exampleapp.data.model.LocationResult
import io.reactivex.Single

interface LocationRepo {

    fun getLocations(page: Int): Single<ResponseInfo<LocationResult>>

    fun getLocationDetails(id: Int): Single<LocationResult>
}