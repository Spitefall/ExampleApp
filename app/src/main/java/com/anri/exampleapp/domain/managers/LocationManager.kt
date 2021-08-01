package com.anri.exampleapp.domain.managers

import com.anri.exampleapp.domain.repositories.LocationRepo
import com.anri.exampleapp.domain.model.locations.Location
import io.reactivex.Single
import javax.inject.Inject

class LocationManager @Inject constructor(private val locationRepo: LocationRepo) {

    fun getLocationDetails(id: Int): Single<Location> =
        locationRepo.getLocationDetails(id).map { Location.from(it) }

    fun getLocations(page: Int): Single<Pair<Int, List<Location>>> =
        locationRepo.getLocations(page).map { Pair(it.info.pages ?: 0, Location.from(it.results)) }
}