package com.example.felixsport.core.domain.usecase

import com.example.felixsport.core.data.Resources
import com.example.felixsport.core.domain.IDataRepository
import com.example.felixsport.core.domain.model.Sport
import kotlinx.coroutines.flow.Flow

class AppInteractor(private val dataRepository: IDataRepository): AppUseCase {
    override fun getAllItem(): Flow<Resources<List<Sport>>> {
        return dataRepository.getAllItem()
    }

    override fun getFavItem(): Flow<List<Sport>> {
        return dataRepository.getFavItem()
    }

    override fun setFavItem(item: Sport, state: Boolean) {
        dataRepository.setFavItem(item, state)
    }

}