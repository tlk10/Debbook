package com.khaled.debbook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
 class Food(
    val name: String,
    val image: Int,
    val places : String,
    val summary: String,
    val ingredients: ArrayList<String>
    ) : Parcelable {


     fun getIngredients() : String {
         var ingredients : String = ""
         for(i in 0..this.ingredients.size-1)
             ingredients= ingredients + this.ingredients[i]
         return ingredients
    }


}