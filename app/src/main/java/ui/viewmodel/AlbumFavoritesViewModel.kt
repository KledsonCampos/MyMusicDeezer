package ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import repository.AlbumRepository

class AlbumFavoritesViewModel(
    repository: AlbumRepository
) : ViewModel() {
    val favoritesAlbum = repository.allFavorites().asLiveData()

}