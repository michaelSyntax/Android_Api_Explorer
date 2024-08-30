package com.example.android_base_starter.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_base_starter.model.MockRepository
import com.example.android_base_starter.model.data.Item
import com.example.android_base_starter.model.data.ReservationRequest
import com.example.android_base_starter.model.data.Restaurant
import com.example.android_base_starter.model.remote.MockApi
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository = MockRepository(MockApi)

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    private val _restaurants = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> get() = _restaurants

    fun getItems() {
        viewModelScope.launch {
            _items.value = repository.getItems()
        }
    }

    fun getRestaurants() {
        viewModelScope.launch {
            _restaurants.value = repository.getRestaurants()
        }
    }

    fun makeReservation(restaurantId: Int, time: String, date: String, numberOfPeople: Int) {
        viewModelScope.launch {
            val request = ReservationRequest(0, "user@mail.com", "5552325", time, date, numberOfPeople)
            repository.makeReservation(request)
        }
    }
}