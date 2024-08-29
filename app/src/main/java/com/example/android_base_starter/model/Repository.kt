package com.example.android_base_starter.model

import androidx.lifecycle.LiveData
import com.example.android_base_starter.model.data.Item
import com.example.android_base_starter.model.remote.Api

class Repository(private val api: Api) {

    suspend fun getItems(): List<Item> {
        return api.service.getItems()
    }
}