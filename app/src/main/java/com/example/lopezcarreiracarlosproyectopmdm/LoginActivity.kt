package com.example.lopezcarreiracarlosproyectopmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityMainBinding



class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btAcceder.setOnClickListener{

        }

        binding.tvRegistro.setOnClickListener{

            //Iniciamos RegistroUsuarios al hacer click en Registro
            val intent = Intent(this,RegistroUsuariosActivity::class.java)
            startActivity(intent)

        }
    }
}