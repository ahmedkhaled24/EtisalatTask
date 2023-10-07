package com.etisalattask.ahmedkhaled.data.repository

import android.content.Context
import com.etisalattask.ahmedkhaled.data.model.response.RecipesResponse
import com.etisalattask.ahmedkhaled.domain.repository.RecipesRepo
import com.etisalattask.ahmedkhaled.utils.jsonFileRead
import javax.inject.Inject

class RecipesRepoImpl @Inject constructor(private val context: Context) : RecipesRepo {
    override suspend fun getRecipesList(): ArrayList<RecipesResponse> {
        return context.jsonFileRead("recipes.json")
    }
}