package com.example.apppractica.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    @SerializedName("id")
    val id:String?,

    @SerializedName("poster_path")
    val poster:String?,

    @SerializedName("title")
    val title:String?,

    @SerializedName("release_date")
    val release_date: String,

    @SerializedName("original_title")
    val original_title: String?,


    ): Parcelable {
    constructor():this("","","","","")
}