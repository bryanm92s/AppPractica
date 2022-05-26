package com.example.apppractica

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_item_view.view.*

class MovieAdapter(var items: ArrayList<Movies>): RecyclerView.Adapter<MovieViewHolder>(){
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        lateinit var movieViewHolder: MovieViewHolder
         movieViewHolder = MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view,parent, false))
        return movieViewHolder
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieLogo.setImageResource(items.get(position).logo)
        holder.movieTitle?.text=items.get(position).title
        holder.movieDate?.text=items.get(position).date
        holder.movieCast?.text=items.get(position).cast

    }

}

class MovieViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var movieLogo=itemView.movielogo
    var movieTitle= itemView.movietitle
    var movieDate = itemView.moviedate
    var movieCast = itemView.moviecast

}