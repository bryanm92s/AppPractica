package com.example.apppractica.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.Movies
import com.example.apppractica.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_item_view.view.*


class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val MovieLogo = view.findViewById<ImageView>(R.id.ivLogo)
    val MovieTitle = view.findViewById<TextView>(R.id.tvMovieTitle)
    val MovieDate = view.findViewById<TextView>(R.id.tvMovieDate)
    val MovieCast = view.findViewById<TextView>(R.id.tvMovieCast)


    fun render(items: Movies) {

        MovieTitle.text = items.title
        MovieDate.text = items.date
        MovieCast.text = items.cast
        Picasso.get().load(items.logo).into(itemView.ivLogo)

        /*itemView.ivLogo.setOnClickListener {
            Toast.makeText(itemView.ivLogo.context, items.title, Toast.LENGTH_SHORT).show()
        }*/

        // Gestionar clicks en el cuadro del RecyclerView

        itemView.setOnClickListener {
            Toast.makeText(itemView.ivLogo.context,items.title,Toast.LENGTH_SHORT).show()

            //val context=itemView.ivLogo.context

            //val intent = Intent(itemView.ivLogo.context, MovieDetail::class.java)

            //intent.putExtra("Title", items.title)
            //intent.putExtra("Cast", items.cast)
            //itemView.context.startActivity(intent);
            //itemView.ivLogo.context.startActivity(intent)
        }

    }

}