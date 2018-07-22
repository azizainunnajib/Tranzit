package com.example.azizainun.maps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bantuan.*
import android.content.Intent
import android.net.Uri


class Bantuan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bantuan)

        whatsapp.setOnClickListener {
            val intentWhatsapp = Intent(Intent.ACTION_VIEW)
            val url = "https://chat.whatsapp.com/send?phone=6287764521758"
            intentWhatsapp.data = Uri.parse(url)
            intentWhatsapp.`package` = "com.whatsapp"
            startActivity(intentWhatsapp)
        }
        telegram.setOnClickListener {
            val intentWhatsapp = Intent(Intent.ACTION_VIEW)
            val url = "https://chat.whatsapp.com/send?phone=6287764521758"
            intentWhatsapp.data = Uri.parse(url)
            intentWhatsapp.`package` = "com.whatsapp"
            startActivity(intentWhatsapp)
        }

        email.setOnClickListener {
            val TO = arrayOf("azizainunnajib@yahoo.co.id")
            val emailIntent = Intent(Intent.ACTION_SEND)

            emailIntent.data = Uri.parse("mailto:")
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO)
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bantuan Tranzit")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here")
        }

        instagram.setOnClickListener {
            val intentIG = Intent(Intent.ACTION_VIEW)
            val url = "instagram.com/tranzit"
            intentIG.data = Uri.parse(url)
            intentIG.`package` = "com.instagram.android"
            startActivity(intentIG)
        }

        facebook.setOnClickListener {
            val intentFB = Intent(Intent.ACTION_VIEW)
            val url = "facebook.com/tranzit"
            intentFB.data = Uri.parse(url)
            intentFB.`package` = "com.facebook.android"
            startActivity(intentFB)
        }
    }
}
