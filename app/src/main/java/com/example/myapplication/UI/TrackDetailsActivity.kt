package com.example.myapplication.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.track_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat

class TrackDetailsActivity: AppCompatActivity() {

    private val trackDetailsViewModel: TrackDetailsViewModel by viewModel()
    private val pattern = "yyyy/MM/dd"
    private val simpleDateFormat = SimpleDateFormat(pattern)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.track_details)
        val trackId = intent.extras?.getInt("trackId")
        trackDetailsViewModel.getTrackById(trackId)
    }

    override fun onStart() {
        super.onStart()
        trackDetailsViewModel.track.observe(this, { track ->
            trackName.text = track?.trackName
            artistName.text = track?.artistName
            collectionName.text = "album : " + track?.collectionName
            val date: String = simpleDateFormat.format(track?.releaseDate)
            releaseDate.text = "date de sortie : $date"
            Picasso.get().load(track?.bigArtwork).into(trackImage);
        })
    }

}