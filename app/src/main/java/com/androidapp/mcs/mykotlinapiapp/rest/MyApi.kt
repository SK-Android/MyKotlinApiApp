package com.androidapp.mcs.mykotlinapiapp.rest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyApi {
    private const val url = "http://www.recipepuppy.com/"


    //Here check if theres a retrofit object if not create on.(Singleton object)

    private var retrofit: Retrofit? = null

    //if (retrofit == null) {
    // }
    val service: Retrofit?
        get() {
            retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit;
        }
}

