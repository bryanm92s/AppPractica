package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apppractica.databinding.ItemHorizontalBinding
import com.example.apppractica.models.BestMovies

class BestMoviesAdapter(private val bestMovieList: List<BestMovies>) : RecyclerView.Adapter<BestMoviesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHorizontalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = bestMovieList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int =  bestMovieList.size

    inner class ViewHolder( val binding: ItemHorizontalBinding) : RecyclerView.ViewHolder(binding.root){
        private val IMAGE_BASE="https://image.tmdb.org/t/p/w500/"

        fun bind(items: BestMovies) {

            Glide.with(itemView).load(IMAGE_BASE + items.poster).into(binding.ivLogo)
            binding.tvstars.text= items.popularity.toString()
            binding.tvtitle.text=items.title

            // Gestionar clicks en el cuadro del RecyclerView
            binding.ivLogo.setOnClickListener {
                Toast.makeText(binding.ivLogo.context,items.title, Toast.LENGTH_SHORT).show()
            }
        }
    }
}