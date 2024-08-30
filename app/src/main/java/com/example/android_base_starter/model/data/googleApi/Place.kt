package com.example.android_base_starter.model.data.googleApi

import com.squareup.moshi.Json

data class Place (
    @Json(name = "formatted_address")
    val formattedAddress: String?,
    val name: String?,
    val photos: List<Photo>?,
    @Json(name = "place_id")
    val placeID: String?,
    val rating: Double?,


)
