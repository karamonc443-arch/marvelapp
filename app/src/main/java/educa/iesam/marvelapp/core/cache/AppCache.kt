package educa.iesam.marvelapp.core.cache

import android.content.Context
import educa.iesam.marvelapp.R
import educa.iesam.marvelapp.core.time.AppTime

interface AppCache {
    fun updateTime(key: String)
    fun isExpired(key: String, timeToLive: Long): Boolean
}

class AppCacheTimeToLive(private val context: Context, private val appTime: AppTime) : AppCache {
    val sharedPref = context.getSharedPreferences(
        context.getString(R.string.app_cache),
        Context.MODE_PRIVATE
    )

    override fun updateTime(key: String) {
        sharedPref.edit().apply {
            putLong(key, appTime.currentTimeToLong())
            apply()
        }
    }

    override fun isExpired(key: String, timeToLive: Long): Boolean {
        val timeSaved = sharedPref.getLong(key, -1)
        return (appTime.currentTimeToLong() - timeSaved) >= timeToLive
    }
}