package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.apppractica.Profile
import com.example.apppractica.R
import com.example.apppractica.databinding.ItemOperacionesHorizontalBinding


class ProfileAdapter(private val profileList: List<Profile>) : androidx.recyclerview.widget.RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_operaciones_horizontal,parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = profileList[position]
        holder.render(item)
    }

    // Tamaño de la lista
    override fun getItemCount(): Int =  profileList.size

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(
        itemView) {

        val binding = ItemOperacionesHorizontalBinding.bind(itemView)


        fun render(items: Profile) {

            binding.descripcion.text=items.descripcion
            binding.titulo.text=items.titulo
            binding.cantidad.text= items.cantidad.toString()

            // Gestionar clicks en el cuadro del RecyclerView
            binding.descripcion.setOnClickListener {
                Toast.makeText(binding.descripcion.context,items.descripcion, Toast.LENGTH_SHORT).show()
            }
        }
    }
}