package com.example.felixsport.core.utils

import com.example.felixsport.core.data.local.SportRoom
import com.example.felixsport.core.data.network.SportsItem
import com.example.felixsport.core.domain.model.Sport

object DataAdapter {
    fun sportItemToSportRoom(input: List<SportsItem>): List<SportRoom>{
        val sportList = ArrayList<SportRoom>()
        input.map {
            val sport = SportRoom(
                it.idSport,
                it.strFormat,
                it.strSport,
                it.strSportThumb,
                it.strSportDescription,
                false
            )
            sportList.add(sport)
        }
        return sportList
    }

    fun sportRoomToSport(input: List<SportRoom>): List<Sport>{
        val sportList = ArrayList<Sport>()
        input.map {
            val sport = Sport(
                it.idSport,
                it.strFormat,
                it.strSport,
                it.strSportThumb,
                it.strSportDescription,
                it.favo
            )
            sportList.add(sport)
        }
        return sportList
    }

    fun sportToSportRoom(input: Sport) : SportRoom{
        return SportRoom(
            input.idSport,
            input.strFormat,
            input.strSport,
            input.strThumb,
            input.strDescription,
            input.strFav
        )
    }
}