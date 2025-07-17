package com.example.fidotest.data.remote.api

import com.example.fidotest.data.remote.dto.NewsResponseDto
import com.example.fidotest.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiService {

    @GET("v2/everything")
    suspend fun getEverything(
        @Query("q") query: String = Constants.DEFAULT_QUERY,
        @Query("from") from: String = Constants.DEFAULT_FROM_DATE,
        @Query("sortBy") sortBy: String = Constants.DEFAULT_SORT_BY,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): NewsResponseDto
}

