package com.example.apppractica.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.apppractica.models.Profile
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

    override fun getItemCount(): Int =  profileList.size

    inner class ViewHolder( val binding: ItemOperacionesHorizontalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(items: Profile) {

            binding.description.text=items.description
            binding.titleProfile.text=items.title_profile
            binding.quantity.text= items.quantity.toString()

            // Gestionar clicks en el cuadro del RecyclerView
            binding.description.setOnClickListener {
                Toast.makeText(binding.description.context,items.description, Toast.LENGTH_SHORT).show()
            }
        }
    }
}