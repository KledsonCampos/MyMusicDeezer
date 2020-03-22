package ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.music.R
import kotlinx.android.synthetic.main.item_tracks.view.*
import model.Track

class TrackListAdapter(
   private val items: List<Track>,
   private val onItemClick: (Track) -> Unit
) : RecyclerView.Adapter<TrackListAdapter.TrackeHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackeHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tracks, parent, false)
        return TrackeHolder(layout)
    }
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TrackeHolder, position: Int) {
        val data = items[position]
        holder.txtNumber.text = data.track_position?:""
        holder.txtTrack.text = data.title?:""
        /*holder.itemView.setOnClickListener {
            onItemClick(data)}*/
    }

    class TrackeHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        val txtNumber: TextView = rootView.txtNumber
        val txtTrack: TextView = rootView.txtTrack
    }
}