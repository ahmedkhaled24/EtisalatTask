package com.etisalattask.ahmedkhaled.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.etisalattask.ahmedkhaled.databinding.FragmentRecipesBinding
import com.etisalattask.ahmedkhaled.presentation.adapters.RecipesAdapter
import com.etisalattask.ahmedkhaled.presentation.viewmodels.RecipesViewModel
import com.etisalattask.ahmedkhaled.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RecipesFragment : Fragment() {

    private lateinit var binding: FragmentRecipesBinding
    private val viewModel: RecipesViewModel by viewModels()
    private lateinit var adapter: RecipesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //init recycler to display data
        setUpRecyclerRecipesData()

        //init viewModel to receiving the response
        viewModel.recipes.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {}

                is Resource.Success -> {
                    adapter.differ.submitList(it.data!!)
                }

                is Resource.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun setUpRecyclerRecipesData() {
        adapter = RecipesAdapter()
        binding.recipesRecyclerView.adapter = adapter
    }
}