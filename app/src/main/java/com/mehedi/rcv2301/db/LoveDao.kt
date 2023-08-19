package com.mehedi.rcv2301.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mehedi.rcv2301.models.Love

@Dao
interface LoveDao {

    @Insert
    suspend fun createLove(love: Love)

    @Update
    suspend fun updateLove(love: Love)

    @Delete
    suspend fun deleteLove(love: Love)

    @Query("SELECT * FROM Love")
    fun getAllLove(): LiveData<MutableList<Love>>

}