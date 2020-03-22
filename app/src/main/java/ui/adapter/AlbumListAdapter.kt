package ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.music.R
import com.example.music.R.drawable.ic_image_black
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_album.view.*
import kotlinx.android.synthetic.main.item_album.view.img
import kotlinx.android.synthetic.main.item_album.view.txtAuthor
import kotlinx.android.synthetic.main.item_album.view.txtTracksNumber
import kotlinx.android.synthetic.main.item_album.view.txtTitle
import model.Album

class AlbumListAdapter(
   private val items: List<Album>,
    private val onItemClick: (Album) -> Unit
) : RecyclerView.Adapter<AlbumListAdapter.AlbumHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_album, parent, false)
        return AlbumHolder(layout)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        val data = items[position]
        if (data.cover?.isNotEmpty() == true){
            Picasso.get()
                .load(data.cover).into(
                    holder.imgAlbum
                )
        } else {
            holder.imgAlbum.setImageResource(ic_image_black)
        }
        holder.txtTitle.text = "Album: "+ data.title?:""
        holder.txtAuthor.text = "Author: "+data.artist?.name?:""
        holder.txtAlbum.text = "Number Tracks: "+data.nb_tracks?:""
        holder.txtType.text = "Type: "+data.record_type?:""
        holder.itemView.setOnClickListener {
            onItemClick(data)
        }
    }

    class AlbumHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
        val imgAlbum: ImageView = rootView.img
        val txtTitle: TextView = rootView.txtTitle
        val txtAuthor: TextView = rootView.txtAuthor
        val txtAlbum: TextView = rootView.txtTracksNumber
        val txtType: TextView = rootView.txtType
    }
}