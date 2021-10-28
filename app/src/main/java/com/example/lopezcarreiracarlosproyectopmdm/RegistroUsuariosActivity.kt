package com.example.lopezcarreiracarlosproyectopmdm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityRegistroUsuariosBinding

class RegistroUsuariosActivity : AppCompatActivity() {

    private lateinit var binding:ActivityRegistroUsuariosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroUsuariosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btRegistrar.setOnClickListener{

            //SharedPreferences

            //Volver a Login
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)

        }
    }
}