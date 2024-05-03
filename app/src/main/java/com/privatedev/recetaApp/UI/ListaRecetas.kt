package com.privatedev.recetaApp.UI

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.privatedev.recetaApp.Adapter.AdapterGripMenu
import com.privatedev.recetaApp.Adapter.RecetaAdapter
import com.privatedev.recetaApp.Manager.DataBaseManager
import com.privatedev.recetaApp.Models.Recetas
import com.privatedev.recetaApp.R
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.common.api.Response
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaRecetas : AppCompatActivity() {
    var adapterclases : DataBaseManager? = null
    lateinit var rv : RecyclerView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_recetas)

        rv = findViewById<RecyclerView>(R.id.recetasRecicle)


        DataBaseManager.getRecetas{ it-> var lista = it


            var adapteReceta = RecetaAdapter(lista)
            rv.layoutManager = LinearLayoutManager(this)
            rv!!.adapter = adapteReceta

        }




        //var adapteReceta =RecetaAdapter(DataBaseManager.getRecetas())
       // DataBaseManager.getRecetas()

        //recicler!!.adapter = adapteReceta
    }



}