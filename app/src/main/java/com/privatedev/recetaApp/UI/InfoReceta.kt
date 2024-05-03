package com.privatedev.recetaApp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.privatedev.recetaApp.R

class InfoReceta : AppCompatActivity() {
    var nombre: String? = null
    var ingredientes: String? = null
    var paso1: String? = null
    var paso2: String? = null
    var paso3: String? = null
    var paso4: String? = null
    var paso5: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_receta)
        nombre = intent.extras!!.getString("nombre")
        ingredientes = intent.extras!!.getString("ingredientes")
        paso1 = intent.extras!!.getString("paso1")
        paso2 = intent.extras!!.getString("paso2")
        paso3 = intent.extras!!.getString("paso3")
        paso4 = intent.extras!!.getString("paso4")
        paso5 = intent.extras!!.getString("paso5")

        this.findViewById<TextView>(R.id.nombreinfo).text = nombre
        this.findViewById<TextView>(R.id.ingredientes).text = ingredientes
        this.findViewById<TextView>(R.id.paso1).text = paso1
        this.findViewById<TextView>(R.id.paso2).text = paso2
        this.findViewById<TextView>(R.id.paso3).text = paso3
        this.findViewById<TextView>(R.id.paso4).text = paso4
        this.findViewById<TextView>(R.id.paso5).text = paso5
    }
}