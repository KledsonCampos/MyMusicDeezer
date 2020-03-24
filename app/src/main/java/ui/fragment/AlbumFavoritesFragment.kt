package ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music.R
import kotlinx.android.synthetic.main.fragment_album_list.*
import model.Album
import repository.AlbumRepository
import ui.AlbumDetailActivity
import ui.adapter.AlbumListAdapter
import ui.viewmodel.AlbumFavoritesViewModel
import ui.viewmodel.AlbumVmFactory

class AlbumFavoritesFragment : Fragment() {
    private val viewModel: AlbumFavoritesViewModel by lazy {
        ViewModelProvider(
            this,
            AlbumVmFactory(
                AlbumRepository(requireContext())
            )
        ).get(AlbumFavoritesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_album_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        searchView.visibility = View.GONE
        recycleView.addItemDecoration(
            DividerItemDecoration(requireContext(),layoutManager.orientation)
        )
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.favoritesAlbum.observe(viewLifecycleOwner, Observer { items ->
            vwLoanding.visibility = View.GONE
            recycleView.adapter = AlbumListAdapter(items, this::openAlbumDetail)
        })
    }

    private fun openAlbumDetail(album: Album) {
        AlbumDetailActivity.open(requireContext(), album)
    }
}