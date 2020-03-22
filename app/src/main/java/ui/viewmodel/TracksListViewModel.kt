package ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import model.Track
import model.TrackListHttp
import java.lang.Exception

class TracksListViewModel: ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    fun loanTracks() {
        if (_state.value != null) return

        viewModelScope.launch {
            _state.value = State.Loanding
            val result = withContext(Dispatchers.IO) {
                TrackListHttp.searchTrackList("https://api.deezer.com/album/302127/tracks")
            }
            if (result?.data == null){
                _state.value = State.Error(Exception("Erro Loandding TracksList"),false)
            } else {
                _state.value = State.Loaded(result.data)
            }
        }
    }

    sealed class State{
        object Loanding: State()
        data class Loaded(val items: List<Track>):State()
        data class Error(val e: Throwable, var hasConsumer: Boolean):State()
    }
}