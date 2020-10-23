package com.example.myapplication.services.interfaces

import com.example.myapplication.data.SearchResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    suspend fun getTracks(@Query("term") artist: String) : Response<SearchResult>

}