package com.example.felixsport

import android.app.Application
import com.example.felixsport.core.di.databaseMod
import com.example.felixsport.core.di.networkMod
import com.example.felixsport.core.di.repositoryMod
import com.example.felixsport.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    useCaseMod,
                    viewModelMod,
                    databaseMod,
                    networkMod,
                    repositoryMod
                )
            )
        }
    }
}