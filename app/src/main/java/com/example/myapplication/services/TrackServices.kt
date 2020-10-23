package com.example.myapplication.services

import com.example.myapplication.data.SearchResult
import com.example.myapplication.services.interfaces.ApiService
import com.example.myapplication.services.interfaces.ITrackServices

class TrackServices(private val apiService: ApiService) : ITrackServices {


    override suspend fun getTracks(artist: String): SearchResult? {
       val result = apiService.getTracks(artist)
            return when {
                result.isSuccessful -> result.body()
                else -> null
            }
    }
}