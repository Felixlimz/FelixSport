package com.example.felixsport.core.data

import com.example.felixsport.core.domain.model.Sport

object DummyData{
    fun generateDummy(): List<Sport>{
        val sports = ArrayList<Sport>()

        sports.add(
            Sport("id1",
            "format1",
            "sport1",
            "thumb1",
            "description1",
            false)
        )

        sports.add(
            Sport("id2",
                "format2",
                "sport2",
                "thumb2",
                "description2",
                false)
        )

        sports.add(
            Sport("id3",
                "format3",
                "sport3",
                "thumb3",
                "description3",
                false)
        )

        sports.add(
            Sport("id4",
                "format4",
                "sport4",
                "thumb4",
                "description4",
                false)
        )

        return sports
    }
}