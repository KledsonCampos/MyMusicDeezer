package com.example.music

import model.AlbumHttp
import model.TrackListHttp
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    /*
    fun TestDeezer() {
       val RearchResult = AlbumHttp.searchAlbum("Eminem")
        RearchResult?.data?.forEach {Album ->
            println(Album.toString())
        }

    }*/

    fun TestDeezer() {
        val RearchResult = TrackListHttp.searchTrackList("https://api.deezer.com/album/302127/tracks")
        RearchResult?.data?.forEach {Track ->
            println(Track.toString())
        }

    }


}
