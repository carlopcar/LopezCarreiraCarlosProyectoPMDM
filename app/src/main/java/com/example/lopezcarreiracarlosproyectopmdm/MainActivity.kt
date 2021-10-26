package com.example.lopezcarreiracarlosproyectopmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var btAcceder:Button
    private lateinit var tvRegistro:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btAcceder.setOnClickListener{

        }

        tvRegistro.setOnClickListener{

            //Iniciamos RegistroUsuarios al hacer click en Registro
            val intent = Intent(this,RegistroUsuariosActivity::class.java)
            startActivity(intent)

        }
    }
}