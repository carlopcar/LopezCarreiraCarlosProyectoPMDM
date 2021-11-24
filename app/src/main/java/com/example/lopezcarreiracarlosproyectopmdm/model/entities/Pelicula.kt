package com.example.lopezcarreiracarlosproyectopmdm.model.entities

import java.io.Serializable

data class Pelicula (
    var id:Long,
    var titulo: String,
    var director: String,
    var genero: String,
    var nota: String,
    var url: String,
    var ano:String,
    var duracion:String,
    var musica:String,
    var fotografia:String,
    var pais:String,
    var descripcion:String
    ):Serializable{



}