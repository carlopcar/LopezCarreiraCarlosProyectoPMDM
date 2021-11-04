package com.example.lopezcarreiracarlosproyectopmdm.model.dao

import android.content.Context

class Preferences(val context: Context) {


    val archivoSP = "SharedPreferences"
    val preferences = context.getSharedPreferences(archivoSP, 0)

    fun guardar(user: String, psswd: String) {

        preferences.edit().putString("email", user).commit()
        preferences.edit().putString("psw", psswd).commit()

    }

    fun recuperarDatos(datoARecuperar: String): String? {

        if (datoARecuperar == "email") {
            return preferences.getString("email", "")
        } else if (datoARecuperar == "psw") {
            return preferences.getString("psw", "")
        }
        return null
    }
}
