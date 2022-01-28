package com.example.lopezcarreiracarlosproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lopezcarreiracarlosproyectopmdm.App.Companion.peliculas
import com.example.lopezcarreiracarlosproyectopmdm.RetrofitClient
import com.example.lopezcarreiracarlosproyectopmdm.adapters.ListaPeliculasAdapter
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityPeliculasBinding
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.PeliculasDaoMockImpl
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeliculasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPeliculasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflamos las vistas
        binding = ActivityPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.fabAnadir.setOnClickListener {
            val intent = Intent(this, EditarActivity::class.java)
            intent.putExtra("posicion-pelicula", 0)
            startActivity(intent)
            Toast.makeText(this, "Añadir película", Toast.LENGTH_SHORT).show()
        }


        //Retrofit
        val context = this

        val llamadaApi: Call<List<Pelicula>> = RetrofitClient.apiRetrofit.getPeliculas()
        llamadaApi.enqueue(object:Callback<List<Pelicula>>{

            override fun onResponse(call: Call<List<Pelicula>>,response: Response<List<Pelicula>>
            ) {
                //Obtenemos los datos de las peliculas
                val peliculas = response.body()

                if (peliculas != null){

                    //Creamos los componentes que necesita el ReciclerView con todas sus películas
                    val layoutManager = LinearLayoutManager(context)
                    val adapter = ListaPeliculasAdapter(peliculas,context)

                    //Asociamos el RecyclerView con sus componentes
                    binding.rvListaPeliculas.adapter = adapter
                    binding.rvListaPeliculas.layoutManager = layoutManager

                }


            }

            override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                Log.d("Prueba", t.message.toString())
            }
        })
    }

    override fun onResume() {
        super.onResume()
        val adapter = ListaPeliculasAdapter(peliculas ,this)
        binding.rvListaPeliculas.adapter = adapter
    }
}