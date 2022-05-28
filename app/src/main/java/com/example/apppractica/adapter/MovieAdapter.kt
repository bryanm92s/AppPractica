package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.Movies
import com.example.apppractica.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item_view.view.*

class MovieAdapter(private val movieList: List<Movies>) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        //lateinit var movieHolder: MovieHolder
        //movieHolder = MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view,parent, false))
        //return movieHolder
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(layoutInflater.inflate(R.layout.layout_item_view,parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        //holder.movieLogo.setImageResource(items.get(position).logo)
        //holder.movieTitle?.text=items.get(position).title
        //holder.movieDate?.text=items.get(position).date
        //holder.movieCast?.text=items.get(position).cast
        //holder.render(items[position])
        val item = movieList[position]
        holder.render(item)

    }

    // Tamaño de la lista
    override fun getItemCount(): Int =  movieList.size


    /*class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //var movieLogo = itemView.movielogo
        //var movieTitle = itemView.movietitle
        //var movieDate = itemView.moviedate
        //var movieCast = itemView.moviecast

    }*/


}





