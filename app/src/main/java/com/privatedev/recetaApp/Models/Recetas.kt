package com.privatedev.recetaApp.Models

import android.media.Image

public class Recetas {



    var nombre: String = ""
    var ingredientes: String = ""
    var imagen: String? = null
    var tipo: String = ""
    var pasoUno: String = ""
    var pasodos: String = ""
    var pasotres: String = ""
    var pasocuatro: String = ""
    var pasocinco: String = ""

    constructor(nombre:String,ingredientes:String, imagen: String?,tipo: String, PasoUno: String, Pasodos: String, Pasotres: String,Pasocuatro: String,Pasocinco: String){

        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.imagen = imagen;
        this.tipo = tipo;
        this.pasoUno = PasoUno;
        this.pasodos = Pasodos;
        this.pasotres = Pasotres;
        this.pasocuatro = Pasocuatro;
        this.pasocinco = Pasocinco
    }
    public constructor() {

    }
}
