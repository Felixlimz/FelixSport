package com.example.felixsport.di

import com.example.felixsport.core.domain.usecase.AppInteractor
import com.example.felixsport.core.domain.usecase.AppUseCase
import com.example.felixsport.presentation.detail.DetailViewModel
import com.example.felixsport.presentation.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseMod = module {
    factory<AppUseCase> { AppInteractor(get()) }
}

val viewModelMod = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}