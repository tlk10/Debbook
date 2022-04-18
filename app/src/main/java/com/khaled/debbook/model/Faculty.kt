package com.khaled.debbook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class Faculty(
    val name: String,
    val image: Int,
    val summary: String,
    val location: String,
    val website: String

) : Parcelable {



}