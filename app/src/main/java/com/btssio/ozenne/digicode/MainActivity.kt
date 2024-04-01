package com.btssio.ozenne.digicode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wifikey_id = findViewById<EditText>(R.id.wifi_key)
        val wifikey = wifikey_id.text.toString();
        val qrcode = findViewById<WebView>(R.id.QR_Code)

        // Chargez l'URL
        qrcode.loadUrl("https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=$wifikey")

        // Display
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(this, wifikey, duration) // in Activity
        toast.show()
    }
}