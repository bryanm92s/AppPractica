package com.example.apppractica

class ProfileProvider {
    companion object{
        val profileList = listOf<Profile>(
            Profile(
                "Calificaciones","Calificar y obtener recomendaciones", 0
            ),
            Profile(
                "Listas","Agregar a listas", 4
            ),
            Profile(
                "Comentarios","Aún sin comentarios", 0
            )
        )
    }
}