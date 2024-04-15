package com.btssio.ozenne.digicode.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.btssio.ozenne.digicode.R

class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val btn_liste_salle = findViewById<Button>(R.id.accessList)
            val intent_liste_salle = Intent(this, ListeSalleActivity::class.java) // Redirection Action

            // Redirection
            btn_liste_salle.setOnClickListener {
                startActivity(intent_liste_salle) // Login Activity
            }
        }
}