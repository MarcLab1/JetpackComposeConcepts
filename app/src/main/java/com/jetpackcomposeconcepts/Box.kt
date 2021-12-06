package com.jetpackcomposeconcepts


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Box(val boxId : Int, val boxName:String) : Parcelable
{


}