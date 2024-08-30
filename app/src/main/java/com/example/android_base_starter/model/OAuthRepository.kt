package com.example.android_base_starter.model

import com.example.android_base_starter.model.data.googleApi.Location
import com.example.android_base_starter.model.remote.OAuthApi

class OAuthRepository(private val oauthApi: OAuthApi) {
    suspend fun getPlacesForTextSearch(query: String) : Location {
        return oauthApi.service.getPlacesForTextSearch(query = query)
    }

    suspend fun getPlacesNearby(radius: String, type: String) : Location {
        val location = "37.069640%2C15.289904"
        return oauthApi.service.getPlacesNearby(
            location = location,
            radius = radius,
            type = type
        )
    }
}