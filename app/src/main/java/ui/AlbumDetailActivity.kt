package ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_album_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import model.Track
import model.TrackListHttp
import model.Album as Album
import ui.viewmodel.TracksListViewModel
import ui.adapter.TrackListAdapter as TrackListAdapter

class AlbumDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_detail)

        val album = intent.getParcelableExtra<Album>(EXTRA_ALBUM)
        if (album != null) {

              if (album.artist?.picture_big?.isNotEmpty() == true){
                  Picasso.get()
                      .load(album.artist?.picture_big).into(
                          imageView
                      )
              } else {
                  imageView.setImageResource(R.drawable.ic_image_black)
              }
           // txtDiscografia.text = "Album: " + album.title ?: ""
            txtAuthor.text =  album.artist?.name ?: ""
            // holder.txtAlbum.text = "Number Tracks: "+data.nb_tracks?:""
            // holder.txtType.text = "Type: "+data.record_type?:""

        } else {
            finish()
        }
    }

    companion object {
        private const val EXTRA_ALBUM = "album"
        fun open(context: Context, album: Album) {
            val detailIntent = Intent(context, AlbumDetailActivity::class.java)
            detailIntent.putExtra(EXTRA_ALBUM, album)
            context.startActivity(detailIntent)
        }
    }

}
