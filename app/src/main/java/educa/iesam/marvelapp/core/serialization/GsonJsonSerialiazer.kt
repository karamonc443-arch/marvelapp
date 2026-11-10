package educa.iesam.marvelapp.core.serialization

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class GsonJsonSerialiazer<T>(private val tipo: Type, private val gson: Gson = Gson()) :
    JsonSerializer<T> {

    override fun toJson(obj: T): String = gson.toJson(obj, tipo)

    override fun fromJson(json: String): T = gson.fromJson<T>(json, tipo)
        ?: throw IllegalArgumentException("El JSON está vacío o es nulo")

    companion object {
        inline fun <reified T> create(gson: Gson = Gson()): GsonJsonSerialiazer<T> =
            GsonJsonSerialiazer(object : TypeToken<T>() {}.type, gson)
    }
}