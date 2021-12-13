package com.example.lopezcarreiracarlosproyectopmdm.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lopezcarreiracarlosproyectopmdm.R
import com.example.lopezcarreiracarlosproyectopmdm.activities.PeliculasActivity
import com.example.lopezcarreiracarlosproyectopmdm.databinding.FragmentLoginBinding
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.Preferences


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var con:Context
    companion object {
        lateinit var preferences: Preferences
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding =  FragmentLoginBinding.inflate(inflater, container, false)
        con = requireContext().applicationContext

        //Inicializamos las preferences
        preferences = Preferences(con)



        //Método al pulsar el botón LOGIN
        binding.btLoginAcceder.setOnClickListener {

            val email = preferences.recuperarDatos("email")
            val psw = preferences.recuperarDatos("psw")

            if (!email.equals(binding.etLoginEmail.text.toString().trim())) {
                binding.etLoginEmail.error = "El usuario no existe"
            } else if (!psw.equals(binding.etLoginPsw.text.toString().trim())) {
                binding.etLoginPsw.error = "La contraseña no es correcta"
            } else {
                val intent = Intent(con, PeliculasActivity::class.java)
                startActivity(intent)
            }

        }

        //Método al pulsar el textview REGISTRO
        binding.tvLoginRegistro.setOnClickListener {

            val ft = activity?.supportFragmentManager?.beginTransaction()
            ft?.replace(R.id.contenedorFragments , RegistroUsuariosFragment())
            ft?.commit()

        }

        return binding.root
    }

}