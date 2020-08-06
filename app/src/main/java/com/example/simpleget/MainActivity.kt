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
                        val textView = findViewById(R.id.text_view_result) as TextView                    }
                }

                    /* if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";
                    textViewResult.append(content);
                }
            }*/
            }


        })

//        call.enqueue(object :Callback<List<UserModel>>




//        //Retrofit instance
//        val retrofit: Retrofit = Retrofit.Builder()
//            .baseUrl("https://simplifiedcoding.net/demos/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        // creating APi instance
//        val iMarvelApi: iUserModel =
//            retrofit.create(com.example.myapplication.iUserModel::class.java)
//        //Call the interfac method
//        val call: Call<List<UserModel>> = iMarvelApi.getUsers()
//
//        call.enqueue(object :Callback<List<UserModel>>{

    }
}