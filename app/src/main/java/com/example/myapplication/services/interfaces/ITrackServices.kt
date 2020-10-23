package com.example.myapplication.services.interfaces

import com.example.myapplication.data.SearchResult

interface ITrackServices {
    suspend fun getTracks(artist: String) : SearchResult?
}