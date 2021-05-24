package com.example.felixsport.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.felixsport.core.domain.usecase.AppUseCase

class FavoriteViewModel(appUseCase: AppUseCase) : ViewModel() {
    val items = appUseCase.getFavItem().asLiveData()
}