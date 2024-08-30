package com.example.android_base_starter.model.data.googleApi

import com.squareup.moshi.Json

data class Photo(
    val height: Long?,
    @Json(name = "html_attributions")
    val htmlAttributions: List<String>?,
    @Json(name = "photo_reference")
    val photoReference: String? ,
    val width: Long?
)
