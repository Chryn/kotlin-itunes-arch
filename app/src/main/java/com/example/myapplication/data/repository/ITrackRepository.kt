package com.example.myapplication.data.repository

import com.example.myapplication.data.SearchResult
import com.example.myapplication.data.TrackInfo

interface ITrackRepository {
    suspend fun getTracks(artist: String) :SearchResult?
    suspend fun getTrackById(id: Int?) : TrackInfo?
}