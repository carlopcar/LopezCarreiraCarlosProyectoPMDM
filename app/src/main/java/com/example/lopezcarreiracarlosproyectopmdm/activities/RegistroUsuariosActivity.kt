package com.example.lopezcarreiracarlosproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
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
                val email = binding.etRegistroEmail.text.toString().trim()
                val psw = binding.etRegistroPsw.text.toString().trim()

                //Volver a Login
                onBackPressed()
            }
        }
    }


    private fun validarEmail(email:String):Boolean{
        val pattern:Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    private fun comprobarDatos():Boolean{

        val nombreUsuario = binding.etRegistroNombreUsuario.text.toString().trim()
        val email = binding.etRegistroEmail.text.toString().trim()
        val telefono = binding.etTelefono.text.toString().trim()
        val psw = binding.etRegistroPsw.text.toString().trim()
        val pswrep = binding.etRegistroRepPsw.text.toString().trim()

        if (!validarEmail(email)) {
            //Si el email es incorrecto
            Toast.makeText(this, "El email no es correcto", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (psw.length < 8 || psw.length > 16) {
            //Comprobamos la longitud de la contraseña
            Toast.makeText(this, "La contraseña no tiene la longitud correcta", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (psw != pswrep) {
            //Comprobamos que las contraseñas sean iguales
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT)
                .show()
            return false
        }else if (TextUtils.isEmpty(nombreUsuario) ||
            TextUtils.isEmpty(email) ||
            TextUtils.isEmpty(telefono) ||
            TextUtils.isEmpty(psw) ||
            TextUtils.isEmpty(pswrep) ){

            Toast.makeText(this, "Debes rellenar todos los datos", Toast.LENGTH_SHORT)
                .show()
            return false
        }
        return true
    }
}