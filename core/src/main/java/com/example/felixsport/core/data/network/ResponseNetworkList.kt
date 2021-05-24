package com.example.felixsport.core.data.network

import com.google.gson.annotations.SerializedName

data class SportsItem(

    @field:SerializedName("idSport")
    val idSport: String,

    @field:SerializedName("strFormat")
    val strFormat: String,

    @field:SerializedName("strSport")
    val strSport: String,

    @field:SerializedName("strSportThumb")
    val strSportThumb: String,

    @field:SerializedName("strSportDescription")
    val strSportDescription: String
)
