package com.jetpackcomposeconcepts

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//in an object class, all methods and variables are static
object MySingleton{

    val singletonUser : User by lazy {  //lazy will only init the object the first time
        User("poopypants@gmail.com", "Mackey", "image.jpeg")
    }

    fun getUserEmail() : String
    {
        return singletonUser.email.toString()
    }

}