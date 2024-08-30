package com.example.android_base_starter.model.remote

import com.example.android_base_starter.BuildConfig
import com.example.android_base_starter.model.data.googleApi.Location
import com.example.android_base_starter.model.data.googleApi.Place
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleApiService {
    @GET("maps/api/place/textsearch/json")
    suspend fun getPlacesForTextSearch(
        @Query("key") apiKey: String = BuildConfig.apiKey,
        @Query("query") query: String): Location

    @GET("maps/api/place/nearbysearch/json")
    suspend fun getPlacesNearby(
        @Query("location") location: String,
        @Query("radius") radius: String,
        @Query("type") type: String,
        @Query("key") apiKey: String = BuildConfig.apiKey): Location
}

object GoogleApi {
    private const val BASE_URL = "https://maps.googleapis.com/"
    private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    private val client = OkHttpClient.Builder().addInterceptor(logger).build()
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val converter = MoshiConverterFactory.create(moshi)

    val service: GoogleApiService by lazy {
        Retrofit.Builder()
            .addConverterFactory(converter)
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(GoogleApiService::class.java)
    }
}