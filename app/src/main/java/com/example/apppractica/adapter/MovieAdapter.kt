package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.Movies
import com.example.apppractica.R
import com.example.apppractica.databinding.ItemHorizontalBinding
import com.example.apppractica.databinding.LayoutItemViewBinding
import com.squareup.picasso.Picasso

class MovieAdapter(private val movieList: List<Movies>) : androidx.recyclerview.widget.RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = movieList[position]
        holder.bind(item)

    }

    // Tamaño de la lista
    override fun getItemCount(): Int =  movieList.size

    inner class ViewHolder( val binding: LayoutItemViewBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(items: Movies) {

            Picasso.get().load(items.logo).into(binding.ivLogo)
            binding.tvMovieTitle.text = items.title
            binding.tvMovieDate.text=items.date
            binding.tvMovieCast.text=items.cast

            // Gestionar clicks en el cuadro del RecyclerView
            binding.ivLogo.setOnClickListener {
                Toast.makeText(binding.ivLogo.context,items.title, Toast.LENGTH_SHORT).show()
            }
        }
    }
}