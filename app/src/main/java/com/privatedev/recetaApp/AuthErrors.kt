package com.privatedev.recetaApp


    fun error(error:String): String {
        if(error == "ERROR_INVALID_CREDENTIAL"){
            return "El email o la contraseña están mal"
        }
        else if(error == "ERROR_INVALID_EMAIL"){
            return "el email es invalido"
        }
        else if(error == "ERROR_WRONG_PASSWORD"){
            return "contraseña equivocada"
        }
        else if(error == "ERROR_EMAIL_ALREADY_IN_USE"){
            return "Este email ya está en uso"
        }
        else if(error == "ERROR_EMAIL_ALREADY_EXISTS"){
            return "Este email existe"
        }
        else if(error == "ERROR_INVALID_ARGUMENT"){
            return "argumento invalido"
        }
        else if(error == "INVALID_PASSWORD"){
            return "contraseña invalida, Debe ser una cadena con al menos seis caracteres."
        }
        else if(error == "ERROR_WEAK_PASSWORD"){
            return "La contraseña es demasiado debil, Debe ser una cadena con al menos seis caracteres."
        }
        else{ return error }


        return TODO("Provide the return value")
    }

