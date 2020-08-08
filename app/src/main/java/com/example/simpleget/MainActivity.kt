package com.example.simpleget
/*
1 Push the code
2 Find the working mechanism
3 How will you log the response
4 Integrate with recycler
5 Save it room DB and than list in recyler view
6 use view model ,live data and data binding
* */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.myapplication.UserModel
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        callPosts()
        callPostByID(5)




    }

    private fun callPostByID(id: Int) {
//Retrofit instance
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // Creating interface method
        val iCodingFlowApi: JsonParseInterface =retrofit.create(com.example.simpleget.JsonParseInterface::class.java)
        //call the interface method
        val call:Call<UserModel> =iCodingFlowApi.getPosts(5)
        call.enqueue(object :Callback<UserModel>{
            override fun onFailure(call: Call<UserModel>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<UserModel>?, response: Response<UserModel>?) {
                Log.i(
                    "Response",
                    GsonBuilder().setPrettyPrinting().create().toJson(response)
                )

                if (response != null) {
                    if(!response.isSuccessful()) {
                        val textView = findViewById(R.id.text_view_result) as TextView
                    }
                }
            }


        })

    }

    private fun callPosts() {
//Retrofit instance
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        // Creating interface method
        val iCodingFlowApi: JsonParseInterface =retrofit.create(com.example.simpleget.JsonParseInterface::class.java)
        //call the interface method
        val call:Call<List<UserModel>> =iCodingFlowApi.getPosts()
        call.enqueue(object :Callback<List<UserModel>>{
            override fun onFailure(call: Call<List<UserModel>>?, t: Throwable?) {
                Log.i(
                    "Response",
                    "response")
            }

            override fun onResponse(
                call: Call<List<UserModel>>?,
                response: Response<List<UserModel>>?
            ) {
                Log.i(
                    "Response",
                    GsonBuilder().setPrettyPrinting().create().toJson(response)
                )

                if (response != null) {
                    if(!response.isSuccessful()) {
                        val textView = findViewById(R.id.text_view_result) as TextView
                    }
                }

            }


        })

    }
}