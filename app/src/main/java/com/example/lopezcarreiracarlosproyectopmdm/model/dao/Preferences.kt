package com.example.lopezcarreiracarlosproyectopmdm.model.dao

import android.content.Context
import android.content.SharedPreferences

class Preferences(val context: Context) {


    private val archivoSP = "SharedPreferences"
    private val preferences: SharedPreferences = context.getSharedPreferences(archivoSP, 0)

    fun guardar(email: String, psw: String) {

        preferences.edit().putString("email", email.trim()).apply()
        preferences.edit().putString("psw", psw.trim()).apply()

    }

    fun recuperarDatos(datoARecuperar: String): String? {

        if (datoARecuperar == "email") {
            return preferences.getString("email", null)
        } else if (datoARecuperar == "psw") {
            return preferences.getString("psw", null)
        }
        return null
    }
}
