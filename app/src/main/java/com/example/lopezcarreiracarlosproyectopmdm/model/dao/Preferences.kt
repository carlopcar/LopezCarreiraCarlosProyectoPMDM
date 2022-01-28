package com.example.lopezcarreiracarlosproyectopmdm.model.dao

import android.content.Context
import android.content.SharedPreferences
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Token

class Preferences(val context: Context) {


    private val archivoSP = "SharedPreferences"
    private val preferences: SharedPreferences = context.getSharedPreferences(archivoSP, 0)

    companion object {
        val CLAVE_TOKEN = "tokenAutenticacion"
        val CLAVE_EMAIL = "email"
    }

    fun guardarToken(token: String ) {
        preferences.edit().putString(CLAVE_TOKEN, token).apply()
    }

    fun guardarEmail(email:String) {
        preferences.edit().putString(CLAVE_EMAIL, email).apply()
    }

    fun recuperarDatosToken(token: String): String? {
        return preferences.getString(CLAVE_TOKEN, "")
    }

    fun recuperarDatosEmail(email: String): String? {
        return preferences.getString(CLAVE_EMAIL, "")
    }
}

