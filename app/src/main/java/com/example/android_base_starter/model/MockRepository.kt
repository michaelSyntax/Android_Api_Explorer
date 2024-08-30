package com.example.android_base_starter.model

import com.example.android_base_starter.model.data.mockApi.Item
import com.example.android_base_starter.model.data.mockApi.ReservationRequest
import com.example.android_base_starter.model.data.mockApi.Restaurant
import com.example.android_base_starter.model.remote.MockApi

class MockRepository(private val mockApi: MockApi) {
    suspend fun getItems(): List<Item> {
        return mockApi.service.getItems()
    }

    suspend fun makeReservation(request: ReservationRequest) {
        mockApi.service.makeReservation(request)
    }

    suspend fun getRestaurants() : List<Restaurant> {
        return mockApi.service.getRestaurants()
    }
}