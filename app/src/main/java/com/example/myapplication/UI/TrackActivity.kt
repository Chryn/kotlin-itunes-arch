package com.example.myapplication.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class TrackActivity : AppCompatActivity() {

    private val trackViewModel: TrackViewModel by viewModel()
    private lateinit var trackAdapter: TrackAdapter
    private lateinit var trackLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }


    override fun onStart() {
        super.onStart()

        trackViewModel.tracks.observe(this, Observer { tracks ->
            trackAdapter = TrackAdapter(this, tracks?.trackDetails ?: listOf())
            trackLayoutManager = LinearLayoutManager(this)

            trackList.layoutManager = trackLayoutManager
            trackList.adapter = trackAdapter
            val dividerItemDecoration = DividerItemDecoration(
                trackList.context,
                trackLayoutManager.orientation
            )
            trackList.addItemDecoration(dividerItemDecoration)
            trackAdapter.notifyDataSetChanged()
        })
    }

    private fun initView() {
        button_id.setOnClickListener {
            trackViewModel.getTracksFromArtist(editText.text.toString())
        }

    }
}