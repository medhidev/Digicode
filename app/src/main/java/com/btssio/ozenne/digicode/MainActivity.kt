package com.btssio.ozenne.digicode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Variables components XML
        val wifikey_id = findViewById<EditText>(R.id.wifi_key)
        val wifikey = wifikey_id.text.toString();
        val btn_logout = findViewById<Button>(R.id.btn_logout)
        val qrcode = findViewById<WebView>(R.id.QR_Code)
        val intent_runLogin = Intent(this, LoginActivity::class.java)

        // URL loading - QRCode
        qrcode.loadUrl("https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=$wifikey")

        // Display
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(this, wifikey, duration) // in Activity

        // Redirection
        btn_logout.setOnClickListener {
            startActivity(intent_runLogin) // Login Activity
        }
    }
}