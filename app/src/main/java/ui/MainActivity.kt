package ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.music.R
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import model.Album
import ui.adapter.AlbumListAdapter
import ui.adapter.AlbumPagerAdapter
import ui.viewmodel.AlbumListViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        viewPager.adapter = AlbumPagerAdapter(this)
        TabLayoutMediator(tablayout, viewPager) { tab, position ->
            tab.setText(
                if (position == 0)
                    R.string.tab_albums
                else
                    R.string.tab_favorites
            )
        }.attach()

    }


}
