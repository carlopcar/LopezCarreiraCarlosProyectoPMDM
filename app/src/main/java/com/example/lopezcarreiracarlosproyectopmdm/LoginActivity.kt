package com.example.lopezcarreiracarlosproyectopmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityLoginBinding



class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btLoginAcceder.setOnClickListener{

        }

        binding.tvLoginRegistro.setOnClickListener{

            //Iniciamos RegistroUsuarios al hacer click en Registro
            val intent = Intent(this,RegistroUsuariosActivity::class.java)
            startActivity(intent)

        }
    }
}