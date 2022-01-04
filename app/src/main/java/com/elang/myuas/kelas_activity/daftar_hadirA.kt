package com.elang.myuas.kelas_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.elang.myuas.Adapter.CatatanAdapter
import com.elang.myuas.Api.ApiRetrofit
import com.elang.myuas.Model.CatatanModel
import com.elang.myuas.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class daftar_hadirA : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var catatanAdapter: CatatanAdapter
    private lateinit var lisNote : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_hadir)

        setupList()
    }

    private fun setupList(){
        lisNote = findViewById(R.id.list_catatan)
        catatanAdapter = CatatanAdapter(arrayListOf())
        lisNote.adapter = catatanAdapter
    }

    override fun onStart() {
        super.onStart()
        getNote()
    }

    private fun getNote(){
        api.data().enqueue(object : Callback<CatatanModel> {
            override fun onResponse(call: Call<CatatanModel>, response: Response<CatatanModel>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.catatan
                    catatanAdapter.setData( listData )
//                    listData.forEach {
//                        Log.e("daftar_hadir","nama ${it.nama}")
//                    }
                }
            }

            override fun onFailure(call: Call<CatatanModel>, t: Throwable) {
                Log.e("daftar_hadir",t.toString())
            }

        })
    }
}