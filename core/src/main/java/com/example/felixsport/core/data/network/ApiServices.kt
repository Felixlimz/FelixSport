package com.example.felixsport.core.data.network

import retrofit2.http.GET

interface ApiServices{
    @GET("api/v1/json/1/all_sports.php")
    suspend fun getItems(): ResponseNetworkEntity
}