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

    @SerializedName("vote_average")
    val vote_average: Double,

    @SerializedName("title")
    val title:String?,

    @SerializedName("original_title")
    val original_title:String?,

    @SerializedName("overview")
    val overview:String?,

    @SerializedName("release_date")
    val release_date:String?,

    @SerializedName("original_language")
    val original_language:String?

): Parcelable {
    constructor():this("","", 0.0,"","","","","")
}