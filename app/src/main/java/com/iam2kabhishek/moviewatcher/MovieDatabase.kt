package com.iam2kabhishek.moviewatcher

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {
        private var instance: MovieDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): MovieDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext,
                    MovieDatabase::class.java,
                    "movies").fallbackToDestructiveMigration().build()
            return instance!!
        }
    }

}