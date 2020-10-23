package com.example.myapplication.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.SearchResult
import com.example.myapplication.data.repository.ITrackRepository
import kotlinx.coroutines.launch

class TrackViewModel(private val trackRepository: ITrackRepository): BaseViewModel() {

    private val _tracks = MutableLiveData<SearchResult?>()
    val tracks: LiveData<SearchResult?> get() = _tracks

    fun getTracksFromArtist(artist: String) {
        viewModelScope.launch {
            _tracks.value = trackRepository.getTracks(artist)
        }
    }
}