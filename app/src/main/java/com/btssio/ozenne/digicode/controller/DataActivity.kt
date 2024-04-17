package com.btssio.ozenne.digicode.controller

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.btssio.ozenne.digicode.R
import androidx.appcompat.app.AppCompatActivity

class DataActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code) // Fichier XML de reference

        // Récupération ID XML
        val wifikey = findViewById<TextView>(R.id.wifi_key)
        val digicode = findViewById<TextView>(R.id.digicode_key)
        val nom_salle = findViewById<TextView>(R.id.nom_salle)

        // Transmet les données du digicode et de la clé WIFI
        digicode.setText(intent.getStringExtra("DIGICODE").toString())
        val code_wifi = intent.getStringExtra("WIFI")
        val salle = intent.getStringExtra("SALLE")

        wifikey.setText(code_wifi)
        nom_salle.setText(salle)

        // Composant du Qrcode
        val qrcode = findViewById<WebView>(R.id.QR_Code)

        val btn_liste_salle = findViewById<Button>(R.id.btn_logout)
        val intent_liste_salle = Intent(this, ListeSalleActivity::class.java) // Redirection Action

        // API -> QRCode
        qrcode.loadUrl("https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=$code_wifi")

        // Redirection
        btn_liste_salle.setOnClickListener {
            startActivity(intent_liste_salle) // Login Activity
        }
    }
}