package com.privatedev.recetaApp.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.privatedev.recetaApp.Models.Recetas
import com.privatedev.recetaApp.R

class RecetaAdapter(private val RecetasArray: MutableList<Recetas>):
    RecyclerView.Adapter<RecetaAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaAdapter.ViewHolder {
        val layoutInflater = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.receta_list_single, parent, false)


        return ViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return RecetasArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = RecetasArray[position]
        holder.nombre.text = p.nombre

    }

    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){

            val nombre = itemView.findViewById<TextView>(R.id.recetaName)

            fun render(recetas: Recetas) {
                nombre.text = recetas.nombre
            }





    }




}