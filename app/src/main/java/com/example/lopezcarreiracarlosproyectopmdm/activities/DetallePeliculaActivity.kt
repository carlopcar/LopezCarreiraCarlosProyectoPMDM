package com.example.lopezcarreiracarlosproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityDetallePeliculaBinding
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityLoginBinding

class DetallePeliculaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetallePeliculaBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}