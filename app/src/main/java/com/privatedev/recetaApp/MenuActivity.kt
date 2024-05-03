package com.privatedev.recetaApp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast

import com.privatedev.recetaApp.Adapter.AdapterGripMenu
import com.privatedev.recetaApp.UI.ListaRecetas

enum class ProviderType{
    BASIC,GOOGLE
}
class MenuActivity : AppCompatActivity() {
    var adaptergrid : AdapterGripMenu? = null;
    var gridView : GridView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        gridView = findViewById(R.id.grid)



        // GUARDAR DATOS

        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email",email)
        prefs.putString("provider",provider)
        prefs.apply()

        //cargarGrid

        var namecomidas =  listOf<String>("Carnes","Pescados","Pastas y Arroz","Ensaladas","Legumbres","Verduras","Desayunos","Salsas","Sopas");
        var iconos =  listOf<Int>(R.drawable.carne,R.drawable.pescado,R.drawable.pastasyarroz,R.drawable.ensalada,R.drawable.legumbres,R.drawable.verduras,R.drawable.desayunos,R.drawable.salsa,R.drawable.sopa);
        var back =  listOf<Int>(R.drawable.carnebackground,R.drawable.pescadoback,R.drawable.sopasback,R.drawable.ensaladaback,R.drawable.legumbresback,R.drawable.verdurasback,R.drawable.desayunoback,R.drawable.salsasback,R.drawable.sopasback);
        var color = listOf<Int>(R.color.red,R.color.blue,R.color.yellow,R.color.green,R.color.primary_green,R.color.orange,R.color.marron,R.color.pink,R.color.yellow);

        adaptergrid = AdapterGripMenu(this,namecomidas, back, iconos,color)
        gridView!!.adapter = adaptergrid


        this.gridView!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->


            RecetasActivity();


        })




        }


    fun RecetasActivity(){
        val intent = Intent(this, ListaRecetas::class.java);
        //intent.putExtra("id",idUsuario);

        startActivity(intent);


    }





    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        moveTaskToBack(true);


    }
    fun backToLogin(){

        val loginIntent = Intent(this,LoginActivity::class.java)

        startActivity(loginIntent)

    }


    fun logout(view: View){

        FirebaseAuth.getInstance().signOut()
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.clear()
        prefs.apply()
        backToLogin()
    }
}