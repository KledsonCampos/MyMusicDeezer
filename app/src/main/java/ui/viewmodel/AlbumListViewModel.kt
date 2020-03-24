package ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import model.Album
import model.AlbumHttp
import java.lang.Exception

class AlbumListViewModel : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state

    fun loanAlbums() {
        if (_state.value != null) return
        search("eminem")
    }

    fun search(query: String) {
        viewModelScope.launch {
            _state.value = State.Loanding
            val result = withContext(Dispatchers.IO) {
                AlbumHttp.searchAlbum(query)
            }
            if (result?.data == null) {
                _state.value = State.Error(Exception("Erro Loandding Album"), false)
            } else {
                _state.value = State.Loaded(result.data)
            }
        }
    }

    sealed class State {
        object Loanding : State()
        data class Loaded(val items: List<Album>) : State()
        data class Error(val e: Throwable, var hasConsumer: Boolean) : State()
    }
}