package com.example.felixsport.presentation.detail

import androidx.lifecycle.ViewModel
import com.example.felixsport.core.domain.model.Sport
import com.example.felixsport.core.domain.usecase.AppUseCase

class DetailViewModel(private  val appUseCase: AppUseCase) : ViewModel() {
    fun setFav(item: Sport, status: Boolean) = appUseCase.setFavItem(item, status)
}