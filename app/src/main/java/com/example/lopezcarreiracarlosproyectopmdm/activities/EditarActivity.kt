package com.example.lopezcarreiracarlosproyectopmdm.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.RetrofitClient.apiRetrofit
import com.example.lopezcarreiracarlosproyectopmdm.databinding.ActivityEditarBinding
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.Preferences
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula
import com.example.lopezcarreiracarlosproyectopmdm.utils.ValidacionesUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditarActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarBinding
    private var pelicula: Pelicula? = null
    private var id: String? = null
    companion object {
        lateinit var preferences: Preferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.extras?.get("id") as String?

        if(id != null) {
            //Retrofit
            DetallePeliculaActivity.preferences = Preferences(this)
            val context = this

            val token = "Bearer " + DetallePeliculaActivity.preferences.recuperarDatosToken("")

            val llamadaApi: Call<Pelicula> = apiRetrofit.getById(token, id)
            llamadaApi.enqueue(object : Callback<Pelicula> {

                override fun onResponse(
                    call: Call<Pelicula>, response: Response<Pelicula>
                ) {

                    pelicula = response.body()!!

                    if (response.code() > 299 || response.code() < 200) {
                        if (response.code() == 401 || response.code() == 500){
                            ValidacionesUtils().reiniciarApp(preferences,context)
                        }

                        Toast.makeText(context, "No ha sido posible recuperar la película", Toast.LENGTH_SHORT).show()

                    } else {

                        binding.tiedTitulo.setText(pelicula?.titulo)
                        binding.tiedDirector.setText(pelicula?.director)
                        binding.tiedGenero.setText(pelicula?.genero)
                        binding.tiedNota.setText(pelicula?.nota)
                        binding.tiedAno.setText(pelicula?.ano)
                        binding.tiedDuracion.setText(pelicula?.duracion)
                        binding.tiedMusica.setText(pelicula?.musica)
                        binding.tiedFoto.setText(pelicula?.fotografia)
                        binding.tiedPais.setText(pelicula?.pais)
                        binding.tiedDesc.setText(pelicula?.descripcion)
                        binding.tiedImagen.setText(pelicula?.url)
                    }
                }

                override fun onFailure(call: Call<Pelicula>, t: Throwable) {
                    Toast.makeText(context,"No se puede acceder a esta página", Toast.LENGTH_SHORT).show()
                }
            })
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_editar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.accion_guardar -> {

                val titulo = binding.tiedTitulo.text.toString().trim()
                val director = binding.tiedDirector.text.toString().trim()
                val genero = binding.tiedGenero.text.toString().trim()
                val nota = binding.tiedNota.text.toString().trim()
                val img = binding.tiedImagen.text.toString().trim()
                val ano = binding.tiedAno.text.toString().trim()
                val duracion = binding.tiedDuracion.text.toString().trim()
                val musica = binding.tiedMusica.text.toString().trim()
                val foto = binding.tiedFoto.text.toString().trim()
                val pais = binding.tiedPais.text.toString().trim()
                val desc = binding.tiedDesc.text.toString().trim()

                if (TextUtils.isEmpty(titulo) || TextUtils.isEmpty(director) ||
                    TextUtils.isEmpty(genero) || TextUtils.isEmpty(nota) ||
                    TextUtils.isEmpty(img) || TextUtils.isEmpty(ano) ||
                    TextUtils.isEmpty(duracion) || TextUtils.isEmpty(musica) ||
                    TextUtils.isEmpty(foto) || TextUtils.isEmpty(desc)
                ) {

                    Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()

                } else {

                    val builder = AlertDialog.Builder(this)
                    val dialog = builder.setTitle("Actualizar películas").setMessage(
                        "¿Estás seguro de querer añadirla a tu lista?"
                    )
                        .setPositiveButton("Aceptar") { _, _ ->
                            if (pelicula != null) {


                                preferences = Preferences(this)

                                val peliculaEditada = Pelicula(pelicula?.id, titulo, director, genero, nota, img, ano, duracion,
                                    musica, foto, pais, desc, "+34627892520")

                                //Retrofit
                                val context = this

                                val token = "Bearer " +preferences.recuperarDatosToken("")

                                val llamadaApi: Call<Unit> = apiRetrofit.editar(token,peliculaEditada)
                                llamadaApi.enqueue(object: Callback<Unit> {

                                    override fun onResponse(call: Call<Unit>, response: Response<Unit>
                                    ) {
                                        //Obtenemos los datos de la pelicula

                                        if (response.code() > 299 || response.code() < 200) {

                                            if (response.code() == 401 || response.code() == 500){
                                                ValidacionesUtils().reiniciarApp(preferences,context)
                                            }

                                            Toast.makeText(context,"No ha sido posible editar la película", Toast.LENGTH_SHORT).show()

                                        }else{
                                            Toast.makeText(context, "Lista actualizada", Toast.LENGTH_SHORT).show()
                                            val intent = Intent(context, PeliculasActivity::class.java)
                                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                            startActivity(intent)

                                        }
                                    }

                                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                                        Toast.makeText(context,"No se puede acceder a esta página", Toast.LENGTH_SHORT).show()
                                    }
                                })



                            } else {

                                preferences = Preferences(this)

                                val pelicula = Pelicula(null, titulo, director, genero, nota, img, ano, duracion,
                                    musica, foto, pais, desc, "+34627892520")

                                //Retrofit
                                val context = this

                                val token = "Bearer " +preferences.recuperarDatosToken("")

                                val llamadaApi: Call<Unit> = apiRetrofit.crear(token,pelicula)
                                llamadaApi.enqueue(object: Callback<Unit> {

                                    override fun onResponse(call: Call<Unit>, response: Response<Unit>
                                    ) {
                                        //Obtenemos los datos de la pelicula

                                        if (response.code() > 299 || response.code() < 200) {

                                            if (response.code() == 401 || response.code() == 500){
                                                ValidacionesUtils().reiniciarApp(preferences,context)
                                            }

                                            Toast.makeText(context,"No ha sido posible cargar la lista de películas", Toast.LENGTH_SHORT).show()

                                        }
                                    }

                                    override fun onFailure(call: Call<Unit>, t: Throwable) {
                                        Toast.makeText(context,"No se puede acceder a esta página", Toast.LENGTH_SHORT).show()
                                    }
                                })

                                Toast.makeText(this, "Lista actulizada", Toast.LENGTH_SHORT).show()
                                finish()

                            }
                        }
                        .setNegativeButton("Cancelar", null).create()

                    dialog.show()
                }
                return true

            }

            R.id.accion_cancelar -> {

                onBackPressed()
                Toast.makeText(this, "Acción cancelada", Toast.LENGTH_SHORT).show()

                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}