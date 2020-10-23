package com.example.myapplication.data.repository

import com.example.myapplication.data.SearchResult
import com.example.myapplication.data.TrackInfo
import com.example.myapplication.services.interfaces.ITrackServices

class TrackRepository( private val trackServices: ITrackServices) : ITrackRepository {
    //Simulation of cache with the tracklist variable
    private var trackList:  SearchResult? = null
    override suspend fun getTracks(artist: String): SearchResult? {
        trackList = trackServices.getTracks(artist)
            return trackList
    }

    override suspend fun getTrackById(id: Int?): TrackInfo? {
        return trackList?.trackDetails?.find {it.trackId == id}
    }

}