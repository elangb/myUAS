package com.elang.myuas.kelas_activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.elang.myuas.R
import kotlinx.android.synthetic.main.activity_contact_me.*

class contact_me : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_me)
        wa()
        telegram()
        facebook()
        instagram()
    }

    fun wa(){
        whatsapp_me.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=6282266922649&text=Hello%20Elang"))
            startActivity(intent)
        }
    }
    fun telegram(){
        telegram_me.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://t.me/elngb"))
            startActivity(intent)
        }
    }
    fun facebook(){
        facebook_me.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.facebook.com/elangbimantoro"))
            startActivity(intent)
        }
    }
    fun instagram(){
        instagram_me.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.instagram.com/me.elng/"))
            startActivity(intent)
        }
    }

}