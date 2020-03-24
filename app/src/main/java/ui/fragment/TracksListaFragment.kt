package ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music.R
import kotlinx.android.synthetic.main.fragment_album_list.*
import kotlinx.android.synthetic.main.fragment_list.recycleView
import model.Track
import ui.TrackListActivity
import ui.adapter.TrackListAdapter
import ui.viewmodel.TracksListViewModel


class TracksListaFragment : Fragment() {
    private val viewModel: TracksListViewModel by lazy {
        ViewModelProvider(this).get(TracksListViewModel::class.java)
    }

    companion object {
        fun newInstance() = TracksListaFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val resource = context.resources

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(requireContext())
        recycleView.layoutManager = LinearLayoutManager(requireContext())
        recycleView.addItemDecoration(
            DividerItemDecoration(requireContext(),layoutManager.orientation)
        )
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is TracksListViewModel.State.Loanding -> {

                }
                is TracksListViewModel.State.Loaded -> {
                    recycleView.adapter =
                        TrackListAdapter(state.items, this::openTrackList)
                }
                is TracksListViewModel.State.Error -> {
                    if (!state.hasConsumer) {
                        state.hasConsumer = true
                        Toast.makeText(requireContext(), R.string.error_loading_Track_Lista, Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        })


        viewModel.loanTracks()
    }

    private fun openTrackList(track: Track) {
        TrackListActivity.open(requireContext(), track)
    }
}