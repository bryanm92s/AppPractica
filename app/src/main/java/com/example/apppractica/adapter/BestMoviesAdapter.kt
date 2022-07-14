package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apppractica.IMAGE_BASE
import com.example.apppractica.databinding.ItemHorizontalBinding
import com.example.apppractica.models.BestMovies

class BestMoviesAdapter(private val bestMovieList: List<BestMovies>, val listener: OnAdapterListener ) : RecyclerView.Adapter<BestMoviesAdapter.ViewHolder>() {
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

        holder.bind(bestMovieList[position])
        holder.itemView.setOnClickListener { listener.onClick(bestMovieList[position]) }
    }

    override fun getItemCount(): Int =  bestMovieList.size

    inner class ViewHolder( val binding: ItemHorizontalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(items: BestMovies) {

            Glide.with(itemView).load(IMAGE_BASE + items.poster).into(binding.ivLogo)
            binding.tvVote.text= items.vote_average.toString()
            binding.tvtitle.text=items.title

        }
    }

    interface OnAdapterListener {
        fun onClick(result: BestMovies)
    }
}