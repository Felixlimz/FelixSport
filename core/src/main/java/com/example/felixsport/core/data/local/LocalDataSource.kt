package com.example.felixsport.core.data.local

import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val roomDao: RoomDao) {
    fun getAllItem(): Flow<List<SportRoom>> = roomDao.getAllItem()
    fun getFavItem(): Flow<List<SportRoom>> = roomDao.getFavItem()
    suspend fun insertItem(items : List<SportRoom>) = roomDao.insertItem(items)

    fun setFavItem(item: SportRoom, state: Boolean){
        item.favo = state
        roomDao.updateItem(item)
    }
}