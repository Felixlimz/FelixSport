package com.example.felixsport.core.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "sports_data")
data class SportRoom (
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "idSport")
    val idSport: String,

    @ColumnInfo(name = "strFormat")
    val strFormat: String,

    @ColumnInfo(name = "strSport")
    val strSport: String,

    @ColumnInfo(name = "strSportThumb")
    val strSportThumb: String,

    @ColumnInfo(name = "strSportDesc")
    val strSportDescription: String,

    @ColumnInfo(name = "favo")
    var favo: Boolean
    )