package com.elang.myuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class logout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialog_konfirmasi = AlertDialog.Builder(this)
        dialog_konfirmasi.apply{
            setTitle("Logout")
            setMessage("Apakah anda yakin ingin keluar?")
            setNegativeButton("Batal"){dialog,which->
                dialog.dismiss()
            }
            setPositiveButton("Keluar"){dialog,which->
                dialog.dismiss()
//                startActivity( Intent(this@logout,login::class.java))
                onDestroy()
                finish()
            }
        }
        dialog_konfirmasi.show()
    }
}