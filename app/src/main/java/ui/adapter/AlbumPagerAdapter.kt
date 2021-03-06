package ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ui.fragment.AlbumFavoritesFragment
import ui.fragment.AlbumListFragment


class AlbumPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) AlbumListFragment() else
            AlbumFavoritesFragment()
    }
}