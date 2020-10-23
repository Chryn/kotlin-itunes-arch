package com.example.myapplication.UI

import android.content.Context
import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.TrackInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.track_item.view.*

class TrackAdapter(
    private val context: Context,
    private val tracks: List<TrackInfo>
): RecyclerView.Adapter<TrackAdapter.TrackViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackAdapter.TrackViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.track_item, parent, false)

        return TrackViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(tracks[position],position)
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

    inner class TrackViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(trackInfo: TrackInfo, position: Int) {
            with(itemView) {
                trackName.text = trackInfo.trackName + " - " + trackInfo.artistName
                Picasso.get().load(trackInfo.bigArtwork).into(trackImage);

                setOnClickListener {
                    val intent = Intent(context, TrackDetailsActivity::class.java)
                    intent.putExtra("trackId", trackInfo.trackId)
                    context.startActivity(intent)
                }
            }
        }
    }
}