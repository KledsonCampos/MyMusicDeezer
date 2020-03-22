package ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.music.R
import kotlinx.android.synthetic.main.item_tracks.*
import model.Track


class TrackListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_album)

        val track = intent.getParcelableExtra<Track>(TrackListActivity.EXTRA_TRACK)
        if (track != null) {
          txtNumber.text = track.track_position
          txtTrack.text = track.title
        } else {
            finish()
        }
    }

    companion object {
        private const val EXTRA_TRACK = "track"
        fun open(context: Context, track: Track) {
            val detailIntent = Intent(context, TrackListActivity::class.java)
            detailIntent.putExtra(EXTRA_TRACK, track)
            context.startActivity(detailIntent)
        }
    }
}