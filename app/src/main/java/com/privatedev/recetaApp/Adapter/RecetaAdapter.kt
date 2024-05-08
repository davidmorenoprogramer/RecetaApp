package com.privatedev.recetaApp.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.privatedev.recetaApp.Models.Recetas
import com.privatedev.recetaApp.R
import com.privatedev.recetaApp.UI.InfoReceta

class RecetaAdapter(private val RecetasArray: MutableList<Recetas>, private val contexto: Context):
    RecyclerView.Adapter<RecetaAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaAdapter.ViewHolder {
        val layoutInflater = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.receta_list_single, parent, false)


        return ViewHolder(layoutInflater,contexto)
    }

    override fun getItemCount(): Int {
        return RecetasArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(RecetasArray[position])
        //holder.nombre.text = p.nombre

    }

    class ViewHolder(private val itemview: View, var contexto: Context): RecyclerView.ViewHolder(itemview){

            val nombre = itemView.findViewById<TextView>(R.id.recetaName)

            fun bind(recetas: Recetas,) {
                nombre.text = recetas.nombre
                this.itemview.setOnClickListener { OnClickListener ->
                    contexto.startActivity(Intent(contexto,InfoReceta::class.java)
                        .putExtra("nombre",recetas.nombre)
                        .putExtra("imagen",recetas.imagen)
                        .putExtra("ingredientes",recetas.ingredientes)
                        .putExtra("paso1",recetas.pasouno)
                        .putExtra("paso2",recetas.pasodos)
                        .putExtra("paso3",recetas.pasotres)
                        .putExtra("paso4",recetas.pasocuatro)
                        .putExtra("paso5",recetas.pasocinco)
                    )
                }
            }





    }




}