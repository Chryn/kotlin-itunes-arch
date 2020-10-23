package com.example.myapplication.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.TrackInfo
import com.example.myapplication.data.repository.ITrackRepository
import kotlinx.coroutines.launch

class TrackDetailsViewModel(private val trackRepository: ITrackRepository): BaseViewModel() {

    private val _track = MutableLiveData<TrackInfo?>()
    val track: LiveData<TrackInfo?> get() = _track

    fun getTrackById(trackId: Int?) {
        viewModelScope.launch {
            _track.value = trackRepository.getTrackById(trackId)
        }
    }
}