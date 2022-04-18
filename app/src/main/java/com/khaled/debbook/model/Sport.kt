package com.khaled.debbook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
class Sport(
    val name: String,
    val image: Int,
    val places: ArrayList<SportPlace>
) : Parcelable {


}