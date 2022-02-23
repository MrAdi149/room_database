package com.example.roomdatabaseentity

import androidx.room.TypeConverter
import java.util.*

class Convertors {
    @TypeConverter
    fun fromDatabaseToLong(value: Date):Long{
        return value.time
    }
    @TypeConverter
    fun fromLongData(value:Long):Date{
        return Date(value)
    }
}