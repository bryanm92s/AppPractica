package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apppractica.databinding.LayoutItemViewBinding
import com.example.apppractica.models.Movies


class MovieAdapter(private val movieList: List<Movies>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

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

    override fun getItemCount(): Int =  movieList.size

    inner class ViewHolder( val binding: LayoutItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        private val IMAGE_BASE="https://image.tmdb.org/t/p/w500/"

        fun bind(items: Movies) {

            Glide.with(itemView).load(IMAGE_BASE + items.poster).into(binding.ivLogo)
            binding.tvMovieTitle.text = items.title
            binding.tvMovieDate.text=items.release_date
            binding.tvMovieCast.text=items.original_title

            // Gestionar clicks en el cuadro del RecyclerView
            binding.ivLogo.setOnClickListener {
                Toast.makeText(binding.ivLogo.context,items.title, Toast.LENGTH_SHORT).show()
            }
        }
    }
}