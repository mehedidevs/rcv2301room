package com.mehedi.rcv2301.repositories

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.mehedi.rcv2301.db.LoveDatabase
import com.mehedi.rcv2301.models.Love
import javax.inject.Inject

class LoveRepo @Inject constructor(private val db: LoveDatabase) {


    fun getAllLove(): LiveData<MutableList<Love>> {

        return db.getLoveDao().getAllLove()

    }

    suspend fun createLove(love: Love) {

        db.getLoveDao().createLove(love)

    }


    suspend fun updateLove(love: Love) {
        db.getLoveDao().updateLove(love)

    }


    suspend fun deleteLove(love: Love) {
        db.getLoveDao().deleteLove(love)
    }

}