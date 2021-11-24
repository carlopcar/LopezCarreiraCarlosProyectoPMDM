package com.example.lopezcarreiracarlosproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.lopezcarreiracarlosproyectopmdm.activities.LoginActivity.Companion.preferences
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityRegistroUsuariosBinding
import java.util.regex.Pattern

class RegistroUsuariosActivity : AppCompatActivity() {

    private lateinit var binding:ActivityRegistroUsuariosBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRegistroUsuariosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btRegistrar.setOnClickListener{

            //SharedPreferences

            if(comprobarDatos()){
                val email = binding.etRegistroEmail.text.toString()
                val psw = binding.etRegistroPsw.text.toString()

                preferences.guardar(email , psw)

                //Volver a Login
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }


    private fun validarEmail(email:String):Boolean{
        val pattern:Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun comprobarDatos():Boolean{
        val psw = binding.etRegistroPsw.text.toString()
        val pswrep = binding.etRegistroRepPsw.text.toString()

        if (!validarEmail(binding.etRegistroEmail.text.toString())) {
            //Si el email es incorrecto
            //Mensaje de que el email es incorrecto
            Toast.makeText(this, "El email no es correcto", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (psw.length < 8 || psw.length > 16) {
            //Comprobamos la longitud de la contraseña
            //Mensaje de que el email es incorrecto
            Toast.makeText(this, "La contraseña no tiene la longitud correcta", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (psw != pswrep) {
            //Mensaje de que el email es incorrecto
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        return true
    }
}