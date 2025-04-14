package edu.jgsilveira.networkdatabase.roomdatabase

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter

@ProvidedTypeConverter
class Converters {
    @TypeConverter
    fun fromFloatToLong(value: Float?): Long? {
        return value?.toLong()
    }

    @TypeConverter
    fun fromLongToFloat(value: Long?): Float? {
        return value?.toFloat()
    }
}