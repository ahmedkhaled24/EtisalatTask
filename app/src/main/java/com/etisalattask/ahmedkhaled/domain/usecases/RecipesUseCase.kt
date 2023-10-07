package com.etisalattask.ahmedkhaled.domain.usecases

import com.etisalattask.ahmedkhaled.data.repository.RecipesRepoImpl
import com.etisalattask.ahmedkhaled.utils.Resource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RecipesUseCase @Inject constructor(private val repository: RecipesRepoImpl) {
    operator fun invoke() = flow {

        try {
            emit(Resource.Loading())
            val response = repository.getRecipesList()
            if (response.isNotEmpty()) {
                emit(Resource.Success(data = response))
            } else {
                emit(Resource.Error("Data Return With Null"))
            }

        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        }
    }
}