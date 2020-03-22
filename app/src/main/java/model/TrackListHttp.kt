package model

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import java.lang.Exception
import java.util.concurrent.TimeUnit
import model.TrackListResult as TrackListResult

object TrackListHttp {
    private val client = OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(5, TimeUnit.SECONDS)
        .build()

    fun searchTrackList(q: String): TrackListResult? {
        val request = Request.Builder()
            .url(q)
            .build()

        try {
            val response = client.newCall(request).execute()
            val json = response.body?.string()
            return Gson().fromJson(json, TrackListResult::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}