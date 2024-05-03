package com.privatedev.recetaApp.Models

import android.media.Image

public class Recetas {



    var nombre: String = ""
    var ingredientes: String = ""
    var imagen: String? = null
    var tipo: String = ""
    var PasoUno: String = ""
    var Pasodos: String = ""
    var Pasotres: String = ""
    var Pasocuatro: String = ""
    var Pasocinco: String = ""

    constructor(nombre:String,ingredientes:String, imagen: String?,tipo: String, PasoUno: String, Pasodos: String, Pasotres: String,Pasocuatro: String,Pasocinco: String){

        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.imagen = imagen;
        this.tipo = tipo;
        this.PasoUno = PasoUno;
        this.Pasodos = Pasodos;
        this.Pasotres = Pasotres;
        this.Pasocuatro = Pasocuatro;
        this.Pasocinco = Pasocinco
    }
    public constructor() {

    }
}
