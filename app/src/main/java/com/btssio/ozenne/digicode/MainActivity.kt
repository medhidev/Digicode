package com.btssio.ozenne.digicode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import com.btssio.ozenne.digicode.bdd.DataCollect
import com.btssio.ozenne.digicode.bdd.DatabaseConnect
import java.sql.ResultSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get DataCollect
        val datacollect = DataCollect()
        val resultSet: ResultSet = DatabaseConnect.getResultSet()
        val db = datacollect.processData(resultSet)

        // Variables components XML
        val wifikey_id = findViewById<EditText>(R.id.wifi_key)
        val code_wifi = wifikey_id.setText(db[0].wifi_key)

        val qrcode = findViewById<WebView>(R.id.QR_Code)
        val btn_logout = findViewById<Button>(R.id.btn_logout)
        val intent_runLogin = Intent(this, LoginActivity::class.java) // Action redirection

        // URL loading - QRCode
        qrcode.loadUrl("https://api.qrserver.com/v1/create-qr-code/?size=200x200&data=$code_wifi")

        // Redirection
        btn_logout.setOnClickListener {
            startActivity(intent_runLogin) // Login Activity
        }
    }
}