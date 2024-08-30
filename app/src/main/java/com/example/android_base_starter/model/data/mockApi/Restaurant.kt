package com.example.android_base_starter.model.data.mockApi

data class Restaurant(
    val createdAt: String,
    val name: String,
    val image: String,
    val latitude: String,
    val longitude: String,
    val rating: Int,
    val openNow: Boolean,
    val phoneNumber: String,
    val id: String,
    val reservations: List<ReservationRequest>
) {
    fun isOpenNow() : String {
        if (openNow) {
            return "open"
        }
        return "closed"
    }

    fun getReservation() : String {
        if (reservations.isEmpty()) {
            return "No Reservation"
        }
        return "Reservation ${reservations.first().date} - ${reservations.first().time}, ${reservations.first().numberOfPeople}"
    }
}
