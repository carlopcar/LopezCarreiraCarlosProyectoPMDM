package com.example.lopezcarreiracarlosproyectopmdm.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.fragments.LoginFragment
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.Preferences


class LoginActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityLoginBinding

    companion object {
        lateinit var preferences: Preferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        title = "FrikiFilm"

        //Inicializamos las preferences
        //preferences = Preferences(applicationContext)

        //binding = ActivityLoginBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        //Método al pulsar el botón LOGIN
        //binding.btLoginAcceder.setOnClickListener {

            //val email = preferences.recuperarDatos("email")
            //val psw = preferences.recuperarDatos("psw")

            //if (!email.equals(binding.etLoginEmail.text.toString().trim())) {
              //  binding.etLoginEmail.error = "El usuario no existe"
            //} else if (!psw.equals(binding.etLoginPsw.text.toString().trim())) {
              //  binding.etLoginPsw.error = "La contraseña no es correcta"
            //} else {
              //  val intent = Intent(this, PeliculasActivity::class.java)
            //    startActivity(intent)
          //  }

        //}

        //Método al pulsar el textview REGISTRO
        //binding.tvLoginRegistro.setOnClickListener {

            //Iniciamos RegistroUsuarios al hacer click en Registro
            //val intent = Intent(this, RegistroUsuariosActivity::class.java)
          //  startActivity(intent)

        //}



        supportFragmentManager.addOnBackStackChangedListener {
            supportActionBar?.setDisplayHomeAsUpEnabled(supportFragmentManager.backStackEntryCount > 0)
        }

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.contenedorFragments,LoginFragment())
        fragmentTransaction.commit()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            supportFragmentManager.popBackStack()
        }

        return super.onOptionsItemSelected(item)
    }
}