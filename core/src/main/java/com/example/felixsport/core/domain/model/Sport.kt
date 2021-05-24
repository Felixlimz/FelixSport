package com.example.felixsport.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sport(
    val idSport: String,
    val strFormat: String,
    val strSport: String,
    val strThumb: String,
    val strDescription: String,
    var strFav: Boolean
): Parcelable