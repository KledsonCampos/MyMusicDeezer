package com.example.music

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import model.Album

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import repository.ALBUM
import repository.AppDatabase

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val db = AppDatabase.getDatabase(appContext)
        val dao = db.getAlbumDao()

        runBlocking {
            val albumUnderTest = ALBUM(
                "Meu Album",
                "Teste Album",
                "Teste Album",
                "https://e-cdns-images.dzcdn.net/images/cover/e2b36a9fda865cb2e9ed1476b6291a7d/500x500-000000-80-0-0.jpg",
                "21",
                listOf("EU","Fulando"),
                listOf("Lista","https://api.deezer.com/album/119606/tracks")
            )
            val rowId = dao.save(albumUnderTest)
            assertTrue(rowId > -1)

            val albums = dao.allFavorites().first()
            albums.forEach{
                assertEquals(it.title, "Teste Album")
            }
            val isFavorite = dao.isFavorite("Meu Album")
            assertTrue(isFavorite == 1)

            val result  = dao.delete(albumUnderTest)
            assertTrue(result == 1)
        }
    }
}
