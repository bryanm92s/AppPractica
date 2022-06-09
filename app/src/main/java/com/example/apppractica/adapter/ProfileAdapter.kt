package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.BestMovies
import com.example.apppractica.Profile
import com.example.apppractica.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_horizontal.view.*
import kotlinx.android.synthetic.main.layout_item_view.view.*

class ProfileAdapter(private val profileList: List<Profile>) : androidx.recyclerview.widget.RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //lateinit var movieHolder: MovieHolder
        //movieHolder = MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_item_view,parent, false))
        //return movieHolder
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_operaciones_horizontal,parent, false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.movieLogo.setImageResource(items.get(position).logo)
        //holder.movieTitle?.text=items.get(position).title
        //holder.movieDate?.text=items.get(position).date
        //holder.movieCast?.text=items.get(position).cast
        //holder.render(items[position])
        val item = profileList[position]
        holder.render(item)

    }

    // Tamaño de la lista
    override fun getItemCount(): Int =  profileList.size

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(
        itemView) {

        val profileDescripcion = itemView.findViewById<TextView>(R.id.descripcion) as TextView
        val profileTitulo = itemView.findViewById<TextView>(R.id.titulo) as TextView
        val profileCantidad = itemView.findViewById<TextView>(R.id.cantidad)as TextView


        fun render(items: Profile) {

            profileDescripcion.text = items.descripcion
            profileTitulo.text=items.titulo
            profileCantidad.text= items.cantidad.toString()

        }

    }
}