package com.example.felixsport.core.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {
    @Query("SELECT * FROM sports_data")
    fun getAllItem(): Flow<List<SportRoom>>

    @Query("SELECT * FROM sports_data where favo = 1")
    fun getFavItem(): Flow<List<SportRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: List<SportRoom>)

    @Update
    fun updateItem(item: SportRoom)
}