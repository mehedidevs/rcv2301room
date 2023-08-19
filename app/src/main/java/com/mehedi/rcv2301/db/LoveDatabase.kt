package com.mehedi.rcv2301.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mehedi.rcv2301.models.Love

@Database(entities = [Love::class], version = 1)
abstract class LoveDatabase : RoomDatabase() {

    abstract fun getLoveDao(): LoveDao

    companion object {

        private var db: LoveDatabase? = null

        fun getDb(context: Context): LoveDatabase {

            return if (db === null) {
                db = Room.databaseBuilder(
                    context,
                    LoveDatabase::class.java,
                    "love_db"
                ).build()
                db as LoveDatabase
            } else {
                db as LoveDatabase
            }


        }


    }

}