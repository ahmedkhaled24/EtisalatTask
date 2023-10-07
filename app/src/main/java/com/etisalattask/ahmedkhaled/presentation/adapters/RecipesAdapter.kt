package com.etisalattask.ahmedkhaled.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.etisalattask.ahmedkhaled.R
import com.etisalattask.ahmedkhaled.data.model.response.RecipesResponse
import com.squareup.picasso.Picasso

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>()  {

    private lateinit var context: Context

    class RecipesViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        // init views
        private val img: ImageView = itemView.findViewById(R.id.recipesImg)
        private val name: TextView = itemView.findViewById(R.id.recipesName)
        private val calories: TextView = itemView.findViewById(R.id.recipesCalories)

        fun bind(context: Context, item: RecipesResponse) {
            Picasso.get().load(item.image).placeholder(R.drawable.ic_launcher_foreground).into(img)
            name.text = context.getString(R.string.name, item.name)
            calories.text = context.getString(R.string.calories, item.calories)
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<RecipesResponse>() {
        override fun areItemsTheSame(
            oldItem: RecipesResponse,
            newItem: RecipesResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RecipesResponse,
            newItem: RecipesResponse
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        context = parent.context
        return RecipesViewHolder(LayoutInflater.from(context).inflate(R.layout.recipes_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bind(context, item)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}