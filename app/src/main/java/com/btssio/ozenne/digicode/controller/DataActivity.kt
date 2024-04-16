package com.btssio.ozenne.digicode.controller

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import com.btssio.ozenne.digicode.R
import androidx.appcompat.app.AppCompatActivity

class DataActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code)

        // Variables components XML
        val wifikey = findViewById<EditText>(R.id.wifi_key)
        val digicode = findViewById<EditText>(R.id.digicode_key)

        // Set values WIFI code & DIGICODE
        digicode.setText("5555")
        val code_wifi = wifikey.setText("mdpWIFI")

        // Qrcode
        val qrcode = findViewById<WebView>(R.id.QR_Code)

        val btn_liste_salle = findViewById<Button>(R.id.btn_logout)
        val intent_liste_salle = Intent(this, ListeSalleActivity::class.java) // Redirection Action

        // URL loading - QRCode
        qrcode.loadUrl("https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=$code_wifi")

        // Redirection
        btn_liste_salle.setOnClickListener {
            startActivity(intent_liste_salle) // Login Activity
        }
    }
}