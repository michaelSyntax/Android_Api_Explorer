package com.example.android_base_starter.model.remote

import com.example.android_base_starter.model.data.Item
import com.example.android_base_starter.model.data.ReservationRequest
import com.example.android_base_starter.model.data.Restaurant
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MockApiService {
    @GET("items")
    suspend fun getItems() : List<Item>

    @GET("restaurants")
    suspend fun getRestaurants() : List<Restaurant>

    @POST("make-reservation")
    suspend fun makeReservation(@Body request: ReservationRequest)
}

object MockApi {
    private const val BASE_URL = "https://66d0aff1181d059277df6c13.mockapi.io/api/1/"
    private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    private val client = OkHttpClient.Builder().addInterceptor(logger).build()
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val converter = MoshiConverterFactory.create(moshi)

    val service: MockApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(converter)
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(MockApiService::class.java)
    }
}