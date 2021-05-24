package com.example.felixsport.core.data

import com.example.felixsport.core.data.local.LocalDataSource
import com.example.felixsport.core.data.network.ApiResponse
import com.example.felixsport.core.data.network.NetworkDataSource
import com.example.felixsport.core.data.network.SportsItem
import com.example.felixsport.core.domain.IDataRepository
import com.example.felixsport.core.domain.model.Sport
import com.example.felixsport.core.utils.AppExecutors
import com.example.felixsport.core.utils.DataAdapter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataRepository(
    private val networkDataSource: NetworkDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IDataRepository{
    override fun getAllItem(): Flow<Resources<List<Sport>>> {
        return object : NetworkBoundRes<List<Sport>, List<SportsItem>>() {
            override fun loadFromDB(): Flow<List<Sport>> {
                return localDataSource.getAllItem().map {
                    DataAdapter.sportRoomToSport(it)
                }
            }

            override fun shouldFetch(data: List<Sport>?): Boolean {
                return data == null || data.isEmpty()
            }

            override suspend fun createCall(): Flow<ApiResponse<List<SportsItem>>> {
                return networkDataSource.getAllData()
            }

            override suspend fun saveCallResult(data: List<SportsItem>) {
                val sportList = DataAdapter.sportItemToSportRoom(data)
                localDataSource.insertItem(sportList)
            }
        }.asFlow()
    }

    override fun getFavItem(): Flow<List<Sport>> {
        return localDataSource.getFavItem().map {
            DataAdapter.sportRoomToSport(it)
        }
    }

    override fun setFavItem(item: Sport, state: Boolean) {
        val sport = DataAdapter.sportToSportRoom(item)
        appExecutors.diskIO().execute {
            localDataSource.setFavItem(sport, state)
        }
    }
}