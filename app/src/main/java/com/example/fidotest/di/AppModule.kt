package com.example.fidotest.di

import com.example.fidotest.data.local.RoomProvider
import com.example.fidotest.data.remote.RetrofitProvider
import com.example.fidotest.data.repositories.news.NewsRepositoryImpl
import com.example.fidotest.domain.news.NewsRepository
import com.example.fidotest.presentation.viewmodels.NewsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { RetrofitProvider.provideRetrofit() }
    single { RetrofitProvider.provideNewsApi(get()) }
}

val databaseModule = module {
    single { RoomProvider.provideDatabase(androidContext()) }
    single { RoomProvider.provideArticleDao(get()) }
}

val repositoryModule = module {
    single<NewsRepository> { NewsRepositoryImpl(get(), get()) }
}

val viewModelModule = module {
    viewModel { NewsViewModel(get()) }
}
