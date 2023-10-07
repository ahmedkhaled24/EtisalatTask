package com.etisalattask.ahmedkhaled.data.model.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipesResponse(
    val calories: String,
    val carbos: String,
    val description: String,
    val difficulty: Int,
    val fats: String,
    val headline: String,
    val id: String,
    val image: String,
    val name: String,
    val proteins: String,
    val thumb: String,
    val time: String
):Parcelable
