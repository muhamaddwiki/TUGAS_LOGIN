package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.login.api.DataRepository
import com.example.login.model.ResponseLogin
import com.example.login.model.ResultLogin
import kotlinx.android.synthetic.main.activity_admin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class admin : AppCompatActivity() {
    private lateinit var LVadmin : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        LVadmin = findViewById<RecyclerView>(R.id.LVadmin)

        showData()
    }

    private fun showData() {
        val call = DataRepository.create().getUsers()
        call.enqueue(object : Callback<ResponseLogin>{
            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Toast.makeText(this@admin, "Mengambil datagagal", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                var data : ArrayList<ResultLogin> = response.body()?.result as ArrayList<ResultLogin>

                val adapter = adapterLV(data)
                LVadmin.adapter=adapter

            }

        })
    }
}
