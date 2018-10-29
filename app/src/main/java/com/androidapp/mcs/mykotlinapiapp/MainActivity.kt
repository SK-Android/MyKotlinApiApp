package com.androidapp.mcs.mykotlinapiapp

import adapter.MyAdapter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.androidapp.mcs.mykotlinapiapp.rest.ApiInterface
import com.androidapp.mcs.mykotlinapiapp.rest.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var recyclerView: RecyclerView? = null
    private var adapter: MyAdapter? = null
    private var pojoList: List<pojo>? = null


    internal var apiInterface = MyApi.service!!.create(ApiInterface::class.java)
    internal var list = apiInterface.postList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.pojo_rv)
        recyclerView!!.setHasFixedSize(true) // Means that every item in RV has a fixed size.
        recyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //cakesList = new ArrayList<Cakes>();

        list.enqueue(object : Callback<List<pojo>> {
            override fun onResponse(call: Call<List<pojo>>, response: Response<List<pojo>>) {
                for (pojoList1 in response.body()!!) {
                    adapter = MyAdapter(applicationContext, listOf(pojoList1) as ArrayList<pojo>)
                    recyclerView!!.adapter = adapter

                }



                assert(pojoList != null)
                Log.d(TAG, "Number of Items received: " + pojoList!!.size)
            }

            override fun onFailure(call: Call<List<pojo>>, t: Throwable) {
                Log.d("Failure", t.message)
            }
        })
    }

    companion object {

        private val TAG = MainActivity::class.java.simpleName
        const val BASE_URL = "http://www.recipepuppy.com"
    }
}

