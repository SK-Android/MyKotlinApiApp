package com.androidapp.mcs.mykotlinapiapp.rest

import com.androidapp.mcs.mykotlinapiapp.pojo
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    //String BASE_URL = "https://gist.githubusercontent.com/hart88/198f29ec5114a3ec3460/raw/";
    @get:GET("api/?i=onions,garlic&q=omelet&p=3")
    val postList: Call<List<pojo>>
}
