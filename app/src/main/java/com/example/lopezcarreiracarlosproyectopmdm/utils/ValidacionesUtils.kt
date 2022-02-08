package com.example.lopezcarreiracarlosproyectopmdm.utils

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.lopezcarreiracarlosproyectopmdm.activities.LoginActivity
import com.example.lopezcarreiracarlosproyectopmdm.activities.PeliculasActivity
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.Preferences

class ValidacionesUtils {

    fun reiniciarApp(pre:Preferences , context: Context){
        pre.guardarToken("")
        val intent = Intent(context, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        context.startActivity(intent)
    }

}