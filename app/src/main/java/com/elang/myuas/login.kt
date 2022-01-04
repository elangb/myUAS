package com.elang.myuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.elang.myuas.Api.ApiRetrofit
import com.elang.myuas.Model.ResponseLogin
import com.elang.myuas.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class login : AppCompatActivity() {

    private var binding : ActivityLoginBinding? = null
    private var nim : String = ""
    private var pass : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnLogin.setOnClickListener {
            nim = binding!!.etNIM.text.toString()
            pass =binding!!.etPassword.text.toString()

            when {
                nim == "" ->{
                    binding!!.wraperNim.error = "NIM tidak boleh kosong"
                    binding!!.wraperPass.error = null
                }
                pass == ""->{
                    binding!!.wraperPass.error = "Password tidak boleh ksong"
                    binding!!.wraperNim.error = null
                }
                else ->{
                    getData()

                }
            }
        }
    }

    private fun getData(){
        val api =ApiRetrofit().getInstance()
        api.login(nim,pass).enqueue(object : Callback<ResponseLogin> {
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                if (response.isSuccessful){
                    if (response.body()?.response == true){
                        startActivity(Intent(this@login, MainActivity::class.java))
                        finish()
                    }else {
                        Toast.makeText(
                            this@login,
                            "Login gagal, silahkan periksa kembali nim dan password",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }else{
                    Toast.makeText(
                        this@login, "Login gagal, terjadi kesalahan", Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.e("pesan error","${t.message}")
            }
        })
    }
}