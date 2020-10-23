package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class SearchResult (
    @SerializedName("resultCount")
    var resultCount: Int,
    @SerializedName("results")
    var trackDetails: List<TrackInfo>,
)