package com.khaled.debbook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Transport(val name: String, val image: Int, val companies: ArrayList<SportPlace>) :
    Parcelable {


}