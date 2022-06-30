package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.BestMovies
import com.example.apppractica.Movies
import com.example.apppractica.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_horizontal.view.*
import kotlinx.android.synthetic.main.layout_item_view.view.*

class MovieAdapter(private val movieList: List<Movies>) : androidx.recyclerview.widget.RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //lateinit var movieHolder: MovieHolder
        //movieHolder = MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view,parent, false))
        //return movieHolder
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.layout_item_view,parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
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

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(
        itemView) {


        val MovieLogo = itemView.findViewById<ImageView>(R.id.ivLogo) as ImageView
        val MovieTitle = itemView.findViewById<TextView>(R.id.tvMovieTitle) as TextView
        val MovieDate = itemView.findViewById<TextView>(R.id.tvMovieDate) as TextView
        val MovieCast = itemView.findViewById<TextView>(R.id.tvMovieCast)as TextView


        fun render(items: Movies) {

            Picasso.get().load(items.logo).into(itemView.ivLogo)
            MovieTitle.text = items.title
            MovieDate.text=items.date
            MovieCast.text=items.cast

            /*itemView.ivLogo.setOnClickListener {
                Toast.makeText(itemView.ivLogo.context, items.title, Toast.LENGTH_SHORT).show()
            }*/

            // Gestionar clicks en el cuadro del RecyclerView

            itemView.setOnClickListener {
                Toast.makeText(itemView.ivLogo.context,items.title, Toast.LENGTH_SHORT).show()

                //val context=itemView.ivLogo.context

                //val intent = Intent(itemView.ivLogo.context, MovieDetail::class.java)

                //intent.putExtra("Title", items.title)
                //intent.putExtra("Cast", items.cast)
                //itemView.context.startActivity(intent);
                //itemView.ivLogo.context.startActivity(intent)
            }

        }

    }
}





