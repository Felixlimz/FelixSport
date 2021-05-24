package com.example.felixsport.favorite

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vafMod = module {
    viewModel { FavoriteViewModel(get()) }
}