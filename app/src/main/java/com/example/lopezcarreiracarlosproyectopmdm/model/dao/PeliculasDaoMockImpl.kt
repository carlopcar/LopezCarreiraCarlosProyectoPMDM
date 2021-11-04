package com.example.lopezcarreiracarlosproyectopmdm.model.dao

import com.example.lopezcarreiracarlosproyectopmdm.model.entities.Pelicula

class PeliculasDaoMockImpl : PeliculasDao {

    override fun getTodos()= listOf(
        Pelicula(
            0,
            "Daenerys",
            "Targaryen",
            "Mother of Dragons",
            "House Targaryen",
            "https://thronesapi.com/assets/images/daenerys.jpg"
        ),
        Pelicula(
            0,
            "Samwell",
            "Tarly",
            "Maester",
            "House Tarly",
            "https://thronesapi.com/assets/images/sam.jpg"
        ),
        Pelicula(
            0,
            "Jon",
            "Snow",
            "King of the North",
            "House Stark",
            "https://thronesapi.com/assets/images/jon-snow.jpg"
        ),
        Pelicula(
            0,
            "Arya",
            "Stark",
            "No One",
            "House Stark",
            "https://thronesapi.com/assets/images/arya-stark.jpg"
        ),
        Pelicula(
            0,
            "Sansa",
            "Stark",
            "Lady of Winterfell",
            "House Stark",
            "https://thronesapi.com/assets/images/sansa-stark.jpeg"
        )
    )

}