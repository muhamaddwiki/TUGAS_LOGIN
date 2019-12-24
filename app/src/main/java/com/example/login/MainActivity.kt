package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.login.api.DataRepository
import com.example.login.model.ResponseLogin
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<TextView>(R.id.username)
        val pass = findViewById<TextView>(R.id.UpPass)
        val btnLogin=findViewById<Button>(R.id.btn_login)


        btnLogin.setOnClickListener {
            val username = username.text.toString().trim()
            val password = pass.text.toString().trim()

            if(username.isEmpty() || password.isEmpty()){

                pass.requestFocus()
                Toast.makeText(this,"username harus ada",Toast.LENGTH_SHORT).show()
            }else{
                login(username,password)
            }
        }
    }

    private fun login(username: String, password: String) {
        val call = DataRepository.create().getLogin(username, password)
        Log.e("TAG", "url ${call.request().url()}")
        call.enqueue(object : Callback<ResponseLogin> {
            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Login gagal", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                val role = response.body()?.result?.get(0)?.role
                if (role.equals("admin")){
                    startActivity(Intent(this@MainActivity, admin::class.java))
                }else{
                    startActivity(Intent(this@MainActivity, user::class.java))
                }
            }

        })

    }
}
