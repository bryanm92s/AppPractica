package com.example.apppractica.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BestMovieResponse (
    @SerializedName("results")
    val BestMovies:List<BestMovies>
):Parcelable {
    constructor():this(mutableListOf())
}