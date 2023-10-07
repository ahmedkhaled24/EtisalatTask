package com.etisalattask.ahmedkhaled.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etisalattask.ahmedkhaled.data.model.response.RecipesResponse
import com.etisalattask.ahmedkhaled.domain.usecases.RecipesUseCase
import com.etisalattask.ahmedkhaled.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(private val recipesUseCase: RecipesUseCase) : ViewModel() {

    private val _recipes: MutableLiveData<Resource<ArrayList<RecipesResponse>>> =
        MutableLiveData()
    val recipes: LiveData<Resource<ArrayList<RecipesResponse>>> = _recipes

    init {
        getTrainingData()
    }

    private fun getTrainingData() {
        viewModelScope.launch {
            recipesUseCase().collect {
                _recipes.postValue(it)
            }
        }
    }

}