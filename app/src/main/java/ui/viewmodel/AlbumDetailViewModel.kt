package ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import model.Album
import repository.AlbumRepository

class AlbumDetailViewModel(
    private val repository: AlbumRepository
): ViewModel() {
    private val _isFavorite = MutableLiveData<Boolean>()
    val isfavorite: LiveData<Boolean> = _isFavorite

    fun onCreate(album: Album){
        viewModelScope.launch {
            _isFavorite.value = repository.isFavolite(album.id)
        }
    }

    fun saveToFavorite(album: Album){
        viewModelScope.launch {
            repository.save(album)
            _isFavorite.value = repository.isFavolite(album.id)
        }
    }

    fun removeFromFavorite(album: Album){
        viewModelScope.launch {
            repository.delete(album)
            _isFavorite.value = repository.isFavolite(album.id)
        }
    }
}