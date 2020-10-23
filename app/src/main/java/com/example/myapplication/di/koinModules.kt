package com.example.myapplication.di

import com.example.myapplication.BuildConfig
import com.example.myapplication.UI.TrackDetailsViewModel
import com.example.myapplication.UI.TrackViewModel
import com.example.myapplication.data.repository.ITrackRepository
import com.example.myapplication.data.repository.TrackRepository
import com.example.myapplication.retrofit.initOkHttpClient
import com.example.myapplication.retrofit.initRetrofitClient
import com.example.myapplication.services.TrackServices
import com.example.myapplication.services.interfaces.ApiService
import com.example.myapplication.services.interfaces.ITrackServices
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@JvmField
val diModules = module {

    single<ITrackRepository> { TrackRepository(trackServices = get())}

    single<ITrackServices> {TrackServices(apiService = get())}

    single { initOkHttpClient() }
    single<ApiService> { initRetrofitClient(get(), BuildConfig.ENDPOINT) }

    factory {
    }
}

val vmModule = module {
    viewModel { TrackViewModel(get()) }
    viewModel { TrackDetailsViewModel(get()) }
}

