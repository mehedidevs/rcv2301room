package com.mehedi.rcv2301.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class Love(

    @PrimaryKey(autoGenerate = true)
    val _id: Int=0,
    @ColumnInfo(name = "love_name")
    val name: String = "",
    @ColumnInfo(name = "love_image")
    val img: String ="",
    @ColumnInfo(name = "love_details")
    val details: String =""
) : Parcelable
