package com.sportapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class News (

    val amiiboSeries: String ="",
    val character : String = "",
    val gameSeries: String = "",
    val image : String = "",
    val name : String ="",

    val head:String ="",
    val tail:String ="",
    val type:String ="",
) : Parcelable
