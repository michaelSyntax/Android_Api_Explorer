package com.example.android_base_starter.model

import com.example.android_base_starter.model.data.googleApi.Location
import com.example.android_base_starter.model.data.googleApi.Place
import com.example.android_base_starter.model.remote.GoogleApi

class GoogleRepository(private val googleApi: GoogleApi) {
    suspend fun getPlacesForTextSearch(query: String) : Location {
        return googleApi.service.getPlacesForTextSearch(query = query)
    }

    suspend fun getPlacesNearby(radius: String, type: String) : Location {
        val location = "37.069640%2C15.289904"
        return googleApi.service.getPlacesNearby(
            location = location,
            radius = radius,
            type = type
        )
    }
}