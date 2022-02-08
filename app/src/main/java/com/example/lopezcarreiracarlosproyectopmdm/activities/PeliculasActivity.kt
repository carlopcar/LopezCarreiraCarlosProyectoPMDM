package com.example.lopezcarreiracarlosproyectopmdm.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lopezcarreiracarlosproyectopmdm.App.Companion.peliculas
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.RetrofitClient
import com.example.lopezcarreiracarlosproyectopmdm.adapters.ListaPeliculasAdapter
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityPeliculasBinding
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.PeliculasDaoMockImpl
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.Preferences
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula
import com.example.lopezcarreiracarlosproyectopmdm.utils.ValidacionesUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PeliculasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPeliculasBinding
    companion object {
        lateinit var preferences: Preferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflamos las vistas
        binding = ActivityPeliculasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = Preferences(this)


        binding.fabAnadir.setOnClickListener {
            val intent = Intent(this, EditarActivity::class.java)
            intent.putExtra("posicion-pelicula", 0)
            startActivity(intent)
            Toast.makeText(this, "Añadir película", Toast.LENGTH_SHORT).show()
        }


        //Retrofit
        val context = this

        val token = "Bearer " + preferences.recuperarDatosToken("")

        val llamadaApi: Call<List<Pelicula>> = RetrofitClient.apiRetrofit.getPeliculas(token)
        llamadaApi.enqueue(object:Callback<List<Pelicula>>{

            override fun onResponse(call: Call<List<Pelicula>>,response: Response<List<Pelicula>>
            ) {
                //Obtenemos los datos de las peliculas
                val peliculas = response.body()

                if (response.code() > 299 || response.code() < 200 || peliculas == null) {

                    if (response.code() == 401 || response.code() == 500){
                        ValidacionesUtils().reiniciarApp(preferences,context)
                    }

                    Toast.makeText(context,"No ha sido posible cargar la lista de películas", Toast.LENGTH_SHORT).show()

                } else {

                    //Creamos los componentes que necesita el ReciclerView con todas sus películas
                    val layoutManager = LinearLayoutManager(context)
                    val adapter = ListaPeliculasAdapter(peliculas,context)

                    //Asociamos el RecyclerView con sus componentes
                    binding.rvListaPeliculas.adapter = adapter
                    binding.rvListaPeliculas.layoutManager = layoutManager
                }
            }

            override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                Toast.makeText(context,"No se puede acceder a esta página", Toast.LENGTH_SHORT).show()
            }
        })
    }


    override fun onResume() {
        super.onResume()
        //Retrofit
        val context = this

        val token = "Bearer " + preferences.recuperarDatosToken("")

        val llamadaApi: Call<List<Pelicula>> = RetrofitClient.apiRetrofit.getPeliculas(token)
        llamadaApi.enqueue(object:Callback<List<Pelicula>>{

            override fun onResponse(call: Call<List<Pelicula>>,response: Response<List<Pelicula>>
            ) {
                //Obtenemos los datos de las peliculas
                val peliculas = response.body()

                if (response.code() > 299 || response.code() < 200 || peliculas == null) {

                    if (response.code() == 401 || response.code() == 500){
                        ValidacionesUtils().reiniciarApp(preferences,context)
                    }

                    Toast.makeText(context,"No ha sido posible cargar la lista de películas", Toast.LENGTH_SHORT).show()

                } else {

                    //Creamos los componentes que necesita el ReciclerView con todas sus películas
                    val layoutManager = LinearLayoutManager(context)
                    val adapter = ListaPeliculasAdapter(peliculas,context)

                    //Asociamos el RecyclerView con sus componentes
                    binding.rvListaPeliculas.adapter = adapter
                    binding.rvListaPeliculas.layoutManager = layoutManager
                }
            }

            override fun onFailure(call: Call<List<Pelicula>>, t: Throwable) {
                Toast.makeText(context,"No se puede acceder a esta página", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_lista_peliculas, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.accion_logout -> {

                val builder = AlertDialog.Builder(this)
                val dialog = builder.setTitle("Salir de la app").setMessage(
                    "Estás a punto de salir de la aplicación, ¿Estás seguro?")
                    .setPositiveButton("Aceptar") { _, _ ->
                        ValidacionesUtils().reiniciarApp(preferences,this)
                    }
                    .setNegativeButton("Cancelar",null)
                    .create()
                dialog.show()

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }
}