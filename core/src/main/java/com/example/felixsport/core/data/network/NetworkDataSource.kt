package com.example.felixsport.core.data.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NetworkDataSource(private val apiServices: ApiServices) {

    suspend fun getAllData(): Flow<ApiResponse<List<SportsItem>>> {
        return flow {
            try {
                val respon = apiServices.getItems()
                val arrayData = respon.sports
                if(arrayData.isNotEmpty()) emit(ApiResponse.Success(respon.sports))
                else emit(ApiResponse.Empty)
            } catch (ex : Exception){
                emit(ApiResponse.Error(ex.toString()))
                Log.e("ERROR NDS", ex.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}