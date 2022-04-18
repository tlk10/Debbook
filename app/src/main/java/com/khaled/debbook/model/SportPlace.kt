package com.khaled.debbook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class SportPlace(
    val placeName : String ,
    val placeLocation : String,
    val placeImage : Int
) : Parcelable {

}