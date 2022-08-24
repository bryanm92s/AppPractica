package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apppractica.IMAGE_BASE
import com.example.apppractica.databinding.LayoutItemViewBinding
import com.example.apppractica.models.Movies


class MovieAdapter(private val movieList: List<Movies>,  val listener: OnAdapterListener) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

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

        holder.bind(movieList[position])
        holder.itemView.setOnClickListener { listener.onClick(movieList[position]) }
    }

    override fun getItemCount(): Int =  movieList.size

    inner class ViewHolder( val binding: LayoutItemViewBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(items: Movies) {

            Glide.with(itemView).load(IMAGE_BASE + items.poster).into(binding.ivLogo)
            binding.tvMovieTitle.text = items.title
            binding.tvMovieDate.text=items.release
            binding.tvMovieCast.text=items.original_title

        }
    }

    interface OnAdapterListener {
        fun onClick(result: Movies)
    }
}


