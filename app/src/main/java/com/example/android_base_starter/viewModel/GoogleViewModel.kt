package com.example.android_base_starter.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_base_starter.model.GoogleRepository
import com.example.android_base_starter.model.data.googleApi.Place
import com.example.android_base_starter.model.data.mockApi.ReservationRequest
import com.example.android_base_starter.model.data.mockApi.Restaurant
import com.example.android_base_starter.model.remote.GoogleApi
import kotlinx.coroutines.launch

class GoogleViewModel(application: Application): AndroidViewModel(application) {
    private val repository = GoogleRepository(GoogleApi)

    private val _places = MutableLiveData<List<Place>?>()
    val places: LiveData<List<Place>?> get() = _places

    fun getPlacesForTextSearch(query: String) {
        viewModelScope.launch {
            _places.value = repository.getPlacesForTextSearch(query).places
        }
    }

    fun getPlacesNearBy() {
        viewModelScope.launch {
            _places.value = repository.getPlacesNearby("5000", "restaurant").places
        }
    }
}