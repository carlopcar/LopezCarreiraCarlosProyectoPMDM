package com.example.lopezcarreiracarlosproyectopmdm

import android.app.Application
import com.example.lopezcarreiracarlosproyectopmdm.model.dao.PeliculasDaoMockImpl
import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula

class App: Application() {

    companion object{
        var peliculas: ArrayList <Pelicula> = ArrayList()
    }

    override fun onCreate() {
        super.onCreate()

        val dao = PeliculasDaoMockImpl()

        peliculas = dao.getTodos()
    }

}