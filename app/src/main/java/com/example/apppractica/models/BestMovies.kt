package com.example.apppractica.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class BestMovies(
    @SerializedName("id")
    val id:String?,

    @SerializedName("poster_path")
    val poster:String?,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("title")
    val title:String?

): Parcelable {
    constructor():this("","", 0.0,"")
}