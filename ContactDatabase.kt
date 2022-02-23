package com.example.roomdatabaseentity

import android.content.Context
import androidx.room.*
import java.time.Instant


@Database(entities = [Contact::class], version = 1)
@TypeConverters(Convertors::class)
abstract class ContactDatabase: RoomDatabase() {
    abstract fun contactDao(): ContactDao
    companion object{
        @volatile
        private var INSTANCE: ContactDatabase? = null

        annotation class volatile

        fun getDatabase(context: Context):ContactDatabase{
            if(INSTANCE == null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,ContactDatabase::class.java,"contactDB").build()
                }
            }
            return INSTANCE!!
        }
    }

}
