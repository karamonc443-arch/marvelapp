package educa.iesam.marvelapp.features.superheroes.data.local.xml

import android.content.Context
import android.content.SharedPreferences
import educa.iesam.marvelapp.R
import educa.iesam.marvelapp.core.cache.AppCache
import educa.iesam.marvelapp.core.serialization.JsonSerializer
import educa.iesam.marvelapp.features.superheroes.domain.SuperHero

class SuperHeroXmlLocalDataSource(
    private val context: Context,
    private val serializer: JsonSerializer<List<SuperHero>>,
    private val appCache: AppCache
) {
    private val keySuperHero: String = "superhero"
    private val timeToLive: Long = 5 * 60 * 100

    val sharedPref : SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.local_source_superhero),
        Context.MODE_PRIVATE
    )

    fun save(superHeroes: List<SuperHero>) {
        sharedPref.edit().apply {
            putString(keySuperHero, serializer.toJson(superHeroes))
            apply()
        }
        appCache.updateTime(keySuperHero)
    }

    fun findAll(): List<SuperHero> {
        if (!appCache.isExpired(keySuperHero, timeToLive)) {
            val jsonList: String? = sharedPref.getString(keySuperHero, null)
            jsonList?.let {
                return serializer.fromJson(it)
            }
        }
        return emptyList()
    }

    fun findById(id: String): SuperHero? {
        return findAll().find { it.id == id }
    }

    fun deleteById(id: String) {
        save(findAll().filterNot { it.id == id })
    }

    fun deleteAll() {
        sharedPref.edit().apply {
            remove(keySuperHero)
            apply()
        }
    }
}