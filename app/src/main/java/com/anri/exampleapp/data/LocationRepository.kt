package com.anri.exampleapp.data

import com.anri.exampleapp.data.rest.ApiService
import com.anri.exampleapp.data.model.ResponseInfo
import com.anri.exampleapp.data.model.LocationResult
import com.anri.exampleapp.domain.repositories.LocationRepo
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LocationRepository @Inject constructor(
    private val apiService: ApiService
) : LocationRepo {

    override fun getLocationDetails(id: Int): Single<LocationResult> =
        apiService.getLocationDetails(id).subscribeOn(Schedulers.io())

    override fun getLocations(page: Int): Single<ResponseInfo<LocationResult>> =
        apiService.getLocations(page).subscribeOn(Schedulers.io())

}

