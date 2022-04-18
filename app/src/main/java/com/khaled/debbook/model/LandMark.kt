package com.khaled.debbook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class LandMark(val name:String , val image:Int , val summary:String , val location: String ):Parcelable  {



}