package com.example.lopezcarreiracarlosproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityLoginBinding
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.Preferences


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    //Objeto compartido para poder leer la clase Preferences desde cualquier otra clase.
    companion object{
        lateinit var preferences: Preferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializamos las preferences
        preferences = Preferences(applicationContext)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Método al pulsar el botón LOGIN
        binding.btLoginAcceder.setOnClickListener{

            val email = preferences.recuperarDatos("email")
            val psw = preferences.recuperarDatos("psw")

            if (!email.equals(binding.etLoginEmail.text.toString())) {
                binding.etLoginEmail.setError("El usuario no existe")
            } else if (!psw.equals(binding.etLoginPsw.text.toString())) {
                binding.etLoginPsw.setError("La contraseña no es correcta")
            } else {
                val intent = Intent(this, PeliculasActivity::class.java)
                startActivity(intent)
            }

        }

        //Método al pulsar el textview REGISTRO
        binding.tvLoginRegistro.setOnClickListener{

            //Iniciamos RegistroUsuarios al hacer click en Registro
            val intent = Intent(this, RegistroUsuariosActivity::class.java)
            startActivity(intent)

        }
    }
}