package com.projects.sebdeveloper6952.examples.interfaces

import retrofit2.http.GET

interface WikipediaApiService {

    @GET("api.php")
    fun hitCountCheck()

    companion object {
        
    }
}