package com.privatedev.recetaApp.Manager

import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject
import com.privatedev.recetaApp.Models.Recetas
import kotlinx.coroutines.async
import org.jetbrains.annotations.Async
import org.json.JSONArray




public class DataBaseManager {


    companion object {


        fun getRecetas(callBack: (MutableList<Recetas>) -> Unit) {
            val listRecetas: MutableList<Recetas> = ArrayList()


            var firestore = Firebase.firestore
                ?.collection("Recetas")
                ?.get()
                ?.addOnSuccessListener { result ->
                    var list = result.documents

                    for (document in list) {

                        var objectReceta = document.toObject(Recetas::class.java)

                        listRecetas?.add(objectReceta as Recetas)

                    }

                }?.addOnFailureListener { exception ->
                    Log.d("STATE", "Error getting documents.", exception)
                }?.addOnCompleteListener(OnCompleteListener { it ->
                    if (it.isSuccessful){callBack(listRecetas)}
                })



        }
    }
}