package com.example.myapplication.data

import android.net.Uri
import com.google.gson.annotations.SerializedName
import java.util.*

data class TrackInfo(
    @SerializedName("trackId")
    var trackId: Int,
    @SerializedName("artistName")
    var artistName: String,
    @SerializedName("collectionName")
    var collectionName: String,
    @SerializedName("trackName")
    var trackName: String,
    @SerializedName("trackPrice")
    var trackPrice: Float,
    @SerializedName("releaseDate")
    var releaseDate: Date,
    @SerializedName("artworkUrl60")
    var smallArtwork: String,
    @SerializedName("artworkUrl100")
    var bigArtwork: String
)