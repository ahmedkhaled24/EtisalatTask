package com.etisalattask.ahmedkhaled.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.etisalattask.ahmedkhaled.R
import com.etisalattask.ahmedkhaled.data.model.response.RecipesResponse
import com.etisalattask.ahmedkhaled.databinding.FragmentRecipesDetailsBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RecipesDetailsFragment: Fragment() {

    private lateinit var binding:FragmentRecipesDetailsBinding
    private val args: RecipesDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRecipesDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fillData(args.recipesItem)

        binding.backIcon.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun fillData(item: RecipesResponse) {
        Picasso.get().load(item.image).placeholder(R.drawable.ic_launcher_foreground).into(binding.recipesImg)
        binding.recipesName.text = getString(R.string.name_top, item.name)
        binding.recipesDescription.text = getString(R.string.desc, item.description)
        binding.recipesCal.text = getString(R.string.calories, item.calories)
        binding.recipesCarbs.text = getString(R.string.carbos, item.carbos)
        binding.recipesFats.text = getString(R.string.fats, item.fats)
        binding.recipesProteins.text = getString(R.string.proteins, item.proteins)
    }

}