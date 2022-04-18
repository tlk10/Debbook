package com.khaled.debbook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Holiday(
    val enname: String,
    val huname: String,
    val image: Int,
    val date: String,
    val summary: String

) : Parcelable {


}