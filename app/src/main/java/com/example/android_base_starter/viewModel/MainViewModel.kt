package com.example.android_base_starter.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_base_starter.model.Repository
import com.example.android_base_starter.model.data.Item
import com.example.android_base_starter.model.remote.Api
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository = Repository(Api)

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    fun getItems() {
        viewModelScope.launch {
            _items.value = repository.getItems()
        }
    }
}