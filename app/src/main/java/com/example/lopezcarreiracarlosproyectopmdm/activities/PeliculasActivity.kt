package com.example.lopezcarreiracarlosproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lopezcarreiracarlosproyectopmdm.adapters.ListaPeliculasAdapter
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityPeliculasBinding
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.PeliculasDaoMockImpl

class PeliculasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPeliculasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflamos las vistas
        binding = ActivityPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Obtenemos los datos de los personajes
        val peliculasDao = PeliculasDaoMockImpl()
        val listaPeliculas = peliculasDao.getTodos()

        //Creamos los componentes que necesita el ReciclerView con todos sus personajes
        val layoutManager = LinearLayoutManager(this)
        val adapter = ListaPeliculasAdapter(listaPeliculas,this)

        //Asociamos el RecyclerView con sus componentes
        binding.rvListaPeliculas.adapter = adapter
        binding.rvListaPeliculas.layoutManager = layoutManager


        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, EditarActivity::class.java)
            startActivity(intent)
        }


    }
}