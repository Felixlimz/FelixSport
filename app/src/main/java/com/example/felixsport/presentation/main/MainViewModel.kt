package com.example.felixsport.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.felixsport.core.domain.usecase.AppUseCase

class MainViewModel(appUseCase: AppUseCase) : ViewModel() {
    val items = appUseCase.getAllItem().asLiveData()
}