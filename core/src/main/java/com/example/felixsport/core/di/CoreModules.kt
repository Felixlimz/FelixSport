package com.example.felixsport.di

import androidx.room.Room
import com.example.felixsport.core.data.DataRepository
import com.example.felixsport.core.data.local.Database
import com.example.felixsport.core.data.local.LocalDataSource
import com.example.felixsport.core.data.network.ApiServices
import com.example.felixsport.core.data.network.NetworkDataSource
import com.example.felixsport.core.domain.IDataRepository
import com.example.felixsport.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


val databaseMod = module {
    factory { get<Database>().roomDao() }
    single {
        val pass: ByteArray = SQLiteDatabase.getBytes("nopassword".toCharArray())
        val factory = SupportFactory(pass)
        Room.databaseBuilder(
            androidContext(),
            Database::class.java, "Sport.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkMod = module {
    single {
        val host = "www.thesportsdb.com"
        val certPinner = CertificatePinner.Builder()
            .add(host, "sha256/ctt1haazs8U6LJbBhG1dMDCxflw6Q5LRFqlJP+iCf3E=")
            .add(host, "sha256/FEzVOUp4dF3gI0ZVPRJhFbSJVXR+uQmMH65xhs1glH4=")
            .add(host, "sha256/Y9mvm0exBk1JoQ57f9Vm28jKo5lFm/woKcVxrYxu80o=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .certificatePinner(certPinner)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.thesportsdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiServices::class.java)
    }
}

val repositoryMod = module {
    single { LocalDataSource(get()) }
    single { NetworkDataSource(get()) }
    factory { AppExecutors() }
    single<IDataRepository> {
        DataRepository(
            get(), get(), get()
        )
    }
}