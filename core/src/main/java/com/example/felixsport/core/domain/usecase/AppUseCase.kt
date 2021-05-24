package com.example.felixsport.core.domain.usecase


import com.example.felixsport.core.data.Resources
import com.example.felixsport.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

interface AppUseCase {
    fun getAllItem(): Flow<Resources<List<Sport>>>
    fun getFavItem(): Flow<List<Sport>>
    fun setFavItem(item: Sport, state: Boolean)
}