package com.etisalattask.ahmedkhaled.utils

import android.content.Context
import com.etisalattask.ahmedkhaled.data.model.response.RecipesResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader

fun Context.jsonFileRead(nameFileJson: String): ArrayList<RecipesResponse> {

    val bufferedReader = BufferedReader(InputStreamReader(assets.open(nameFileJson)))
    val jsonContent = bufferedReader.use { it.readText() }
    val listType = object : TypeToken<ArrayList<RecipesResponse>>() {}.type
    return Gson().fromJson(jsonContent, listType)
}
