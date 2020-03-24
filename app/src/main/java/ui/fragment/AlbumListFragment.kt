package ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music.R
import kotlinx.android.synthetic.main.fragment_album_list.*
import model.Album
import ui.AlbumDetailActivity
import ui.adapter.AlbumListAdapter
import ui.viewmodel.AlbumListViewModel

class AlbumListFragment : Fragment() {
    private val viewModel: AlbumListViewModel by lazy {
        ViewModelProvider(this).get(AlbumListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_album_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.addItemDecoration(
            DividerItemDecoration(requireContext(),layoutManager.orientation)
        )
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is AlbumListViewModel.State.Loanding -> {
                    vwLoanding.visibility = View.VISIBLE
                }
                is AlbumListViewModel.State.Loaded -> {
                    vwLoanding.visibility = View.GONE
                    recycleView.adapter =
                        AlbumListAdapter(state.items, this::openAlbumDetail)
                }
                is AlbumListViewModel.State.Error -> {
                    vwLoanding.visibility = View.GONE
                    if (!state.hasConsumer) {
                        state.hasConsumer = true
                        Toast.makeText(requireContext(), R.string.error_loading, Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        })
        viewModel.loanAlbums()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    viewModel.search(query)
                    return true
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun openAlbumDetail(album: Album) {
        AlbumDetailActivity.open(requireContext(), album)
    }
}