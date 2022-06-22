package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.Profile
import com.example.apppractica.databinding.ItemOperacionesHorizontalBinding

class ProfileAdapter(private val profileList: List<Profile>) : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemOperacionesHorizontalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = profileList[position]
        holder.bind(item)
    }

    // Tamaño de la lista
    override fun getItemCount(): Int =  profileList.size

    inner class ViewHolder( val binding: ItemOperacionesHorizontalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(items: Profile) {

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