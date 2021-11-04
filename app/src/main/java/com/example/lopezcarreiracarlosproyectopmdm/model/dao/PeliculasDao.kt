package com.example.lopezcarreiracarlosproyectopmdm.model.dao

import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula

interface PeliculasDao {

    //public List <Pelicula> getTodos/getAll/obtenerTodos();

    fun getTodos(): List<Pelicula>

}