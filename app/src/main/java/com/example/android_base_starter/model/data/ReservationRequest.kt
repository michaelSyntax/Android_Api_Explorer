package com.example.android_base_starter.model.data

data class ReservationRequest(
    val restaurantId: Int,
    val userEmail: String,
    val userPhone: String,
    val time: String,
    val date: String,
    val numberOfPeople: Int
)
