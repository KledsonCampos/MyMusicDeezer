package model

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.util.concurrent.TimeUnit

object AlbumHttp {
    private const val URI = "https://api.deezer.com/search/album?q=%s"
    //"https://api.deezer.com/search/album?q=eminem"
    //private const val URI = "https://api.deezer.com/search?q=artist:%s"
    private const val Filter = ""
   // private const val Filter = "&?ARTIST_DESC&index=0"
    private val client = OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .build()

    fun searchAlbum(q: String): SearchResult? {
        val request = Request.Builder()
            .url(String.format(URI, q))
            .build()

        try {
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            return Gson().fromJson(json, SearchResult::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}