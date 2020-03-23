package ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import repository.AlbumRepository
import java.lang.IllegalArgumentException

class AlbumVmFactory(val repository: AlbumRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlbumFavoritesViewModel::class.java)){
            return AlbumFavoritesViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(AlbumDetailViewModel::class.java)){
            return AlbumDetailViewModel(repository) as T
        }
        throw IllegalArgumentException("Unkown ViewModel class")
    }
}