package br.com.gabrielmarcos.coroutines_sunflower.db
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MapTypeConverter {

    // @TypeConverter
    // @JvmStatic
    // fun fromString(value: String): Map<String, GistFile> {
    //     val mapType = object : TypeToken<Map<String, GistFile>>() {}.type
    //     return Gson().fromJson(value, mapType)
    // }
    //
    // @TypeConverter
    // @JvmStatic
    // fun fromStringMap(map: Map<String, GistFile>): String {
    //     val gson = Gson()
    //     return gson.toJson(map)
    // }
}