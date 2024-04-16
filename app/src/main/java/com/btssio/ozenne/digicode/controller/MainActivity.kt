package com.btssio.ozenne.digicode.controller

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.btssio.ozenne.digicode.R
import com.btssio.ozenne.digicode.repository.CodeRepository

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val btn_liste_salle = findViewById<Button>(R.id.accessList)
            val codeRepository = CodeRepository(this@MainActivity)
            val codes = codeRepository.getCode()

            if (codes.size > 1) {
                val secondCode = codes[1]  // Accès à la deuxième entrée
                Log.d("MainActivity", "Digicode: ${secondCode.digicode}")
                Log.d("MainActivity", "WifiKey: ${secondCode.wifikey}")
                Log.d("MainActivity", "Nom de la salle: ${secondCode.nom_salle}")
                Log.d("MainActivity", "Date: ${secondCode.date}")
            } else {
                Log.e("MainActivity", "Not enough data in JSON")
            }

            // Redirection
            btn_liste_salle.setOnClickListener {
                val intent_liste_salle = Intent(this, ListeSalleActivity::class.java) // Redirection Action
                startActivity(intent_liste_salle) // Liste Salle Activity
            }
        }
}