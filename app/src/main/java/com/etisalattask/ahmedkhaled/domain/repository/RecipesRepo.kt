package com.etisalattask.ahmedkhaled.domain.repository

import com.etisalattask.ahmedkhaled.data.model.response.RecipesResponse

interface RecipesRepo {
    suspend fun getRecipesList(): ArrayList<RecipesResponse>
}