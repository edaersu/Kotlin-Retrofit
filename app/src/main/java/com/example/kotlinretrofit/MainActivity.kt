package com.example.kotlinretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinretrofit.Adapter.UserAdapter
import com.example.kotlinretrofit.Model.User
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userlist = ArrayList<User>()
        recycler.adapter = UserAdapter(userlist)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //Retrofit Builder
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()

        val jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi::class.java)

        val mycall: Call<List<User>> = jsonPlaceholderApi.getUsers()

        mycall.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                response.body()?.let { userlist.addAll(it) }
                recycler.adapter?.notifyDataSetChanged()

            }

        })
    }

}