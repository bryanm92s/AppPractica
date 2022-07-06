package com.example.apppractica.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse (
    @SerializedName("items")
    val Movies:List<Movies>
): Parcelable {
    constructor():this(mutableListOf())
}